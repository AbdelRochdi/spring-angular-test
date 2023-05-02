package lu.atozdigital.api.controllers;

import lu.atozdigital.api.dtos.AuthenticationRequestDTO;
import lu.atozdigital.api.dtos.AuthenticationResponseDTO;
import lu.atozdigital.api.dtos.RegisterRequestDTO;
import lu.atozdigital.api.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody RegisterRequestDTO request
    ) {
        return ResponseEntity.ok(accountService.register(request));
    }

    @CrossOrigin
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(
            @RequestBody AuthenticationRequestDTO request
    ) {
        return ResponseEntity.ok(accountService.authenticate(request));
    }

}
