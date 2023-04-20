package com.toyproject.bookmanagement.dto.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class LoginReqDto {
	
	@Email
	private String email;
	
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,16}$", message = "비밀번호는 영문자, 숫자, 특수문자를 포함하여 8~ 16자로 작성")
	private String password;
	
	

				

	
	

}
