package com.example.myProject.MyIMBD.MovieAdviser;

import com.example.myProject.MyIMBD.Exception.AuthTokenMissing;
import com.example.myProject.MyIMBD.Exception.MovieNotFound;
import com.example.myProject.MyIMBD.error.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MovieAdviser {
    @ExceptionHandler(AuthTokenMissing.class)
    public ResponseEntity<Errors>  authTokenMissings(AuthTokenMissing missing){
        Errors errors=new Errors();
        errors.setErrorCode("ERR58");
        errors.setErrorMessage(missing.getMessage());
        return  new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MovieNotFound.class)
    public ResponseEntity<Errors>  movieNotFound(MovieNotFound notFound){
        Errors errors=new Errors();
        errors.setErrorCode("ERR60");
        errors.setErrorMessage(notFound.getMessage());
        return  new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}
