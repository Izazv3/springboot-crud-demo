package com.ensat.controllers;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.*;
@RestControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(IllegalArgumentException.class) ResponseEntity<Map<String,Object>> conflict(IllegalArgumentException e){return response(HttpStatus.CONFLICT,e.getMessage());}
 @ExceptionHandler(RuntimeException.class) ResponseEntity<Map<String,Object>> notFound(RuntimeException e){return response(HttpStatus.NOT_FOUND,e.getMessage());}
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<Map<String,Object>> validation(MethodArgumentNotValidException e){Map<String,String> errors=new LinkedHashMap<>();e.getBindingResult().getFieldErrors().forEach(x->errors.put(x.getField(),x.getDefaultMessage()));Map<String,Object>b=new LinkedHashMap<>();b.put("timestamp",Instant.now());b.put("status",400);b.put("message","Validation failed");b.put("errors",errors);return ResponseEntity.badRequest().body(b);}
 private ResponseEntity<Map<String,Object>> response(HttpStatus s,String m){Map<String,Object>b=new LinkedHashMap<>();b.put("timestamp",Instant.now());b.put("status",s.value());b.put("message",m);return ResponseEntity.status(s).body(b);}
}