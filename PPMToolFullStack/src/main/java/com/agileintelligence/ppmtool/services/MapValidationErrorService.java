package com.agileintelligence.ppmtool.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class MapValidationErrorService {
	
	public ResponseEntity<Map<String, String>> mapValidationError(BindingResult result){
		if(result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			result.getFieldErrors().stream()
									.forEach(fieldError -> errorMap.put(fieldError.getField(), fieldError.getDefaultMessage()));
			return new ResponseEntity<Map<String, String>>(errorMap,HttpStatus.BAD_REQUEST);
		}
		
		return null;
	}

}
