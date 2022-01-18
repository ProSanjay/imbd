package com.example.myProject.MyIMBD.MovieService;

import com.example.myProject.MyIMBD.DAOs.MovieDAO;
import com.example.myProject.MyIMBD.Exception.MovieNotFound;
import com.example.myProject.MyIMBD.model.ActorModel;
import com.example.myProject.MyIMBD.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import java.util.List;

@Service
public class ActorService {
    @Autowired
    MovieDAO movieDAO;
    Response response=new Response();
    public ResponseEntity<Response> updateListofActors(ActorModel model ,String mName) throws MovieNotFound{
        if(mName.equals(movieDAO.getmName())){
            movieDAO.setmListOfActors(model.getList());
            response.setMessage("List of Acotors updated");
            response.setMovieDAO(movieDAO);
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            throw new MovieNotFound("movie not found");
        }
    }
    public  ResponseEntity<Response> actortookPart(String actor) throws MovieNotFound{
        List<String> list=movieDAO.getmListOfActors ();
        for(String s:list){
            if(actor.equals (s)){
                response.setMovieDAO ( movieDAO);
                response.setMessage ( "list of movies in given actor took part " );
                return new ResponseEntity<> ( response,HttpStatus.OK );
            }
        }
        throw new MovieNotFound ( "movie not found" );
    }
}
