package com.example.myProject.MyIMBD.MovieController;

import com.example.myProject.MyIMBD.Exception.AuthTokenMissing;
import com.example.myProject.MyIMBD.Exception.MovieNotFound;
import com.example.myProject.MyIMBD.MovieService.MovieService;
import com.example.myProject.MyIMBD.model.MovieModel;
import com.example.myProject.MyIMBD.model.PMovieModel;
import com.example.myProject.MyIMBD.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/addMovie")
    public ResponseEntity<Response> addMovie(@RequestBody MovieModel movie, HttpServletRequest request) throws AuthTokenMissing{
        String token=request.getHeader("X-Auth-Token");
     if(!StringUtils.hasText(token)){
         throw new AuthTokenMissing("auth-token-missing");
     }else {
          return  movieService.addMovie(movie);

     }
    }
    @PutMapping("/update/{mName}/{mYearOfRelease}/{ratting}") //url path
    public ResponseEntity<Response> completeUpdate(@RequestBody MovieModel model, @PathVariable String mName, @PathVariable  String mYearOfRelease, @PathVariable Integer ratting ) throws MovieNotFound {

      return movieService.completeUpdate(model,mName,mYearOfRelease,ratting);
    }
    @PutMapping("/partial")  //Query parameter
    public ResponseEntity<Response> partailUpdate(@RequestBody PMovieModel model,@RequestParam String mName) throws MovieNotFound{
             return movieService.partialUpdate(model,mName);
    }
    @DeleteMapping("/delete/{mName}/{mId}")
    public ResponseEntity<Response> deleteMovie(@PathVariable String mName, @PathVariable String mId) throws MovieNotFound{
       return  movieService.deleteMovie(mName,mId);
    }
    @GetMapping
    public ResponseEntity<Response> movie() throws MovieNotFound{
        return  movieService.movie();
    }
    @PutMapping("/update/{mName}/{mRatting}")
    public ResponseEntity<Response> updateRatting(@PathVariable String mName, @PathVariable Integer mRatting)throws MovieNotFound{
        return movieService.updateRatting(mName,mRatting);
    }
    @GetMapping("/{genre}")
    public ResponseEntity<Response> fetchbyGenre(@PathVariable String genre) throws MovieNotFound{
        return movieService.fetchbyGenre(genre);
    }
    @GetMapping("/{mName}/{mId}")
    public ResponseEntity<Integer> ratting(@PathVariable String mName,@PathVariable String mId) throws MovieNotFound{
        return movieService.rattingByMovie ( mName,mId );
    }
    @GetMapping("/ratting")
    public ResponseEntity<Response> movieByRatting(@RequestParam Integer ratting) throws MovieNotFound{
        return movieService.movieByRatting ( ratting  );
    }
    @GetMapping("/list/{genre}" )
    public ResponseEntity<Response> movieByGenreYear(@PathVariable String genre,@RequestParam String yearOfRelease) throws MovieNotFound{

        return movieService.moviebyGenreYear ( genre,yearOfRelease );
    }
}
