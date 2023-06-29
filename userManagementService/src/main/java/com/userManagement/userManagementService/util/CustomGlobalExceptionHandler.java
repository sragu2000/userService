//package com.userManagement.userManagementService.util;
//
//import jakarta.validation.ConstraintViolation;
//import org.hibernate.exception.ConstraintViolationException;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//@ControllerAdvice
//@Validated
//public class CustomGlobalExceptionHandler  extends ResponseEntityExceptionHandler {
//
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers,
//                                                                  HttpStatus status, WebRequest request) {
//
//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("timestamp", new Date());
//        body.put("status", status.value());
//
//        //Get all errors
//        List<String> errors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(x -> x.getDefaultMessage())
//                .collect(Collectors.toList());
//
//        body.put("errors", errors);
//
//        return new ResponseEntity<>(body, headers, status);
//
//    }
//
//    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e) {
//        Map<String, Object> body = new LinkedHashMap<>();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        body.put("timestamp", new Date());
//        body.put("status", HttpStatus.BAD_REQUEST);
//
//        //Get all errors
//        List<String> errors = new ArrayList<>(  );
//       for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
//           errors.add(violation.getMessage());
//        }
//
//        body.put("errors", errors);
//        return new ResponseEntity<>(body, httpHeaders, HttpStatus.BAD_REQUEST);
////        return new ResponseEntity<Object>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//}
