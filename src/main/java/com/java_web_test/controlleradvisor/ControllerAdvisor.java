package com.java_web_test.controlleradvisor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.java_web_test.customexception.RequiredFieldException;
import com.java_web_test.model.ErrorDTO;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handleArithmeticException(ArithmeticException ex, WebRequest request ){
		ErrorDTO eDTO = new ErrorDTO();
		eDTO.setError(ex.getMessage());
		List<String> details = new ArrayList<>();
		details.add("Devided by 0!");
		eDTO.setList(details);
		return new ResponseEntity<>(eDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(RequiredFieldException.class)
	public ResponseEntity<Object> handleRequiredField(RequiredFieldException rfe, WebRequest request){
		ErrorDTO eDTO = new ErrorDTO();
		eDTO.setError(rfe.getMessage());
		List<String> details = new ArrayList<>();
		details.add("Da co field nhan gia tri rong hoac null");
		eDTO.setList(details);
		return new ResponseEntity<>(eDTO, HttpStatus.BAD_GATEWAY);
	}
}
