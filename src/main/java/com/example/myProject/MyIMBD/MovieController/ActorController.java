package com.example.myProject.MyIMBD.MovieController;

import com.example.myProject.MyIMBD.Exception.MovieNotFound;
import com.example.myProject.MyIMBD.MovieService.ActorService;
import com.example.myProject.MyIMBD.model.ActorModel;
import com.example.myProject.MyIMBD.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actors")
public class ActorController {
 @Autowired
 ActorService actorService;

 @PutMapping ( "/update/{mName}" )
 public ResponseEntity< Response > updateListOfActors ( @RequestBody ActorModel model, @PathVariable String mName ) throws MovieNotFound {
  return actorService.updateListofActors ( model, mName );
 }

 @GetMapping ( "/{actorName}" )
 public ResponseEntity<Response>  movieActorTookPart(@PathVariable String actorName) throws MovieNotFound{
  return  actorService.actortookPart ( actorName );
 }
}
