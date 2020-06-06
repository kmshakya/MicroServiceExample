package com.app.mobilews.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.mobilews.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleAnyExceptions(Exception es,WebRequest request){
		
		String msg=es.getLocalizedMessage();
		if(msg==null) msg=es.toString();
		ErrorMessage errorMessage=new ErrorMessage(msg,new Date());
		
		return new ResponseEntity<>(errorMessage,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value= {NullPointerException.class,UserServiceException.class})
	public ResponseEntity<Object> handleSprcificExceptions(Exception es,WebRequest request){
		
		String msg=es.getLocalizedMessage();
		if(msg==null) msg=es.toString();
		ErrorMessage errorMessage=new ErrorMessage(msg,new Date());
		
		return new ResponseEntity<>(errorMessage,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
