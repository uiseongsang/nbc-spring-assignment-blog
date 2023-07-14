//package com.sparta.springlv2.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import javax.naming.AuthenticationException;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler({AuthenticationException.class})
//    public ResponseEntity<RestApiException> authenticationExceptionHandler(AuthenticationException ex) {
//        RestApiException restApiException = new RestApiException(ex.getMessage(), HttpStatus.UNAUTHORIZED.value());
//        return new ResponseEntity<>(
//                // HTTP body
//                restApiException,
//                // HTTP status code
//                HttpStatus.UNAUTHORIZED
//        );
//    }
//}
