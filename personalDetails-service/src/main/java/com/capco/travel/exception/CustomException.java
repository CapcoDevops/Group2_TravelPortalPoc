package com.capco.travel.exception;

//import org.apache.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class CustomException extends Exception{
      public CustomException(String Exception) {
    	  super(Exception);
      }
}
