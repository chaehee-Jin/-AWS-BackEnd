package com.toyproject.bookmanagement.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toyproject.bookmanagement.dto.book.SearchBookReqDto;

@RestController
public class BookController {
	
	@GetMapping("/books") //제이쓴으로 보낸것은 아님
	public ResponseEntity<?> searchBooks(SearchBookReqDto searchBookReqDto){
		return ResponseEntity.ok().body(null);
		
		
	}

}
