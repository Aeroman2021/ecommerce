package com.project.ecommerce.exception;

import com.project.ecommerce.model.entity.Cart;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // هندل خطاهای عمومی (مثل throw new RuntimeException)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<Void>> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.internalServerError()
                .body(ApiResponse.failure(ex.getMessage()));
    }

    @ExceptionHandler(CartFinalizeException.class)
    public ResponseEntity<ApiResponse<Cart>> cartFinalizeException(CartFinalizeException cartFinalizeException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.failure(cartFinalizeException.getMessage()));
    }



}
