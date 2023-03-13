package lu.atozdigital.api.shared.controllers;

import lu.atozdigital.api.shared.dtos.ApiErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ApiErrorDTO handleException(RuntimeException exception) {
        return new ApiErrorDTO(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

}
