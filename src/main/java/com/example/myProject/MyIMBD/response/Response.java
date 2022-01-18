package com.example.myProject.MyIMBD.response;

import com.example.myProject.MyIMBD.DAOs.MovieDAO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Data
@Component()
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private String message;
    private MovieDAO movieDAO;
}
