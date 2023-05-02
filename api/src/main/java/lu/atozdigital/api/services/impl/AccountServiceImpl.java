package lu.atozdigital.api.services.impl;

import lu.atozdigital.api.dtos.AuthenticationRequestDTO;
import lu.atozdigital.api.dtos.AuthenticationResponseDTO;
import lu.atozdigital.api.dtos.RegisterRequestDTO;
import lu.atozdigital.api.dtos.SecurityUserDTO;
import lu.atozdigital.api.models.Account;
import lu.atozdigital.api.repositories.AccountRepository;
import lu.atozdigital.api.services.AccountService;
import lu.atozdigital.api.shared.configuration.JwtService;
import lu.atozdigital.api.shared.enums.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AuthenticationResponseDTO register(RegisterRequestDTO request) {
        Account account = modelMapper.map(request, Account.class);
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        account.setRole(Role.ROLE_USER);

        Account persistedAccount = accountRepository.save(account);
        Map<String, Object> claims = new HashMap<>();
        claims.put("account_id", persistedAccount.getId());
        String jwtToken = jwtService.generateToken(claims, new SecurityUserDTO(account));

        return new AuthenticationResponseDTO(jwtToken);
    }

    @Override
    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        Account account = accountRepository.findByEmail(request.getEmail())
                .orElseThrow();
        Map<String, Object> claims = new HashMap<>();
        claims.put("account_id", account.getId());
        String jwtToken = jwtService.generateToken(claims, new SecurityUserDTO(account));

        return new AuthenticationResponseDTO(jwtToken);
    }

}
