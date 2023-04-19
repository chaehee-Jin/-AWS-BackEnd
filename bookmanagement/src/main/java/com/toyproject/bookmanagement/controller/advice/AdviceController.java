package com.toyproject.bookmanagement.controller.advice;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.toyproject.bookmanagement.dto.common.ErrorResponseDto;
import com.toyproject.bookmanagement.exception.CustomException;

@RestControllerAdvice
public class AdviceController {
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<?> CustomException(CustomException e){ // 던져진 customException 매개변수 전달
		return ResponseEntity.badRequest().body(new ErrorResponseDto<>(e.getMessage(), e.getErrorMap()));
	}


}
