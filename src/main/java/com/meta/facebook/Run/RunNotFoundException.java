package com.meta.facebook.Run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RunNotFoundException extends RuntimeException{
	public RunNotFoundException(){
//		super invokes super/parent class constructor code
		super("Run Not Found!!");
	}
}
