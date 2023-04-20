package com.toyproject.bookmanagement.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.toyproject.bookmanagement.dto.auth.JwtRespDto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {
	private final Key key;

	public JwtTokenProvider(@Value("${jwt.secret}") String secretKey) {
		key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));

	}

	public JwtRespDto generateToken(Authentication authentication) {

		
		
		StringBuilder builder = new StringBuilder();
		authentication.getAuthorities().forEach(authority -> {
			builder.append(authority.getAuthority() + ","); // 문자열 사용가능 
			
		});
		
		builder.delete(builder.length() - 1, builder.length());
		
		String authorities = builder.toString();

		Date tokenExpiresDate = new Date(new Date().getTime() + (1000 * 60 * 60 * 24)); // 현재시간 + 하루

		String accessToken = Jwts.builder().setSubject(authentication.getName()) // 토큰의 제목(큰이름), getName() = email
				.claim("auth", authorities) // auth
				.setExpiration(tokenExpiresDate) // 토큰의 만료기간
				.signWith(key, SignatureAlgorithm.HS256) // 토큰 암호화
				.compact();

		return JwtRespDto.builder().grantType("Bearer").accessToken(accessToken).build();

	}

}
