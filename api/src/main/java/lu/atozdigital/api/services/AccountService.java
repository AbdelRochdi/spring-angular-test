package lu.atozdigital.api.services;

import lu.atozdigital.api.dtos.AuthenticationRequestDTO;
import lu.atozdigital.api.dtos.AuthenticationResponseDTO;
import lu.atozdigital.api.dtos.RegisterRequestDTO;

public interface AccountService {

    AuthenticationResponseDTO register(RegisterRequestDTO request);

    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request);
}
