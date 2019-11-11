package com.turing.tshirtshop.exceptions;

import com.turing.tshirtshop.utils.ErrorCodeUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler{

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        Map<String, Object> error = new LinkedHashMap<>();
        String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();

        error.put("status", status.value());
        error.put("code", ErrorCodeUtil.getErrorCodes().get(errorMessage));
        error.put("message", errorMessage);
        error.put("field", ex.getBindingResult().getFieldError().getField());
        body.put("error", error);

        return new ResponseEntity<Object>(body, headers, status);
    }
}
