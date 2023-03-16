package lu.atozdigital.api.shared.controllers;

import lu.atozdigital.api.shared.dtos.ApiErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandlerController.class.getName());

    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ApiErrorDTO handleException(Exception exception) {
        LOGGER.log(Level.SEVERE, exception.getMessage());
        return new ApiErrorDTO(HttpStatus.BAD_REQUEST, "BAD_REQUEST");
    }

}
