package io.javabrians.com.topic;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -3139834993543796086L;

	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}
