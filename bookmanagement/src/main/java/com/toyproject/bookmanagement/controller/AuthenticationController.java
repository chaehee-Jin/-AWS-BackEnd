package com.toyproject.bookmanagement.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toyproject.bookmanagement.aop.annotation.ValidAspect;
import com.toyproject.bookmanagement.dto.auth.LoginReqDto;
import com.toyproject.bookmanagement.dto.auth.SignupReqDto;
import com.toyproject.bookmanagement.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	
	private final AuthenticationService authenticationService;
	

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginReqDto loginReqDto){
		System.out.println(loginReqDto);
		return ResponseEntity.ok(null);
	}
	
	@ValidAspect
	@PostMapping("/signup") //valid이 알아서 검사해줌 valid와 bindingresult랑은 한세트, 전처리로 validaspect가 실행
	public ResponseEntity<?>signup(@Valid @RequestBody SignupReqDto signupReqDto, BindingResult bindingResult){
		authenticationService.checkDuplicatedEmail(signupReqDto.getEmail());
		authenticationService.signup(signupReqDto);
		return ResponseEntity.ok().body(true);
	}
	
	
	
	
	

}
