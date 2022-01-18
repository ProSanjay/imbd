package com.example.myProject.MyIMBD.Exception;

import com.example.myProject.MyIMBD.error.Errors;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
public class AuthTokenMissing extends  Exception{
  private  String message;
  public  AuthTokenMissing(String s){
      this.message=s;
  }
}
