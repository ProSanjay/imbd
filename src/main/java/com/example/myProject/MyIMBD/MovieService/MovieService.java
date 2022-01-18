package com.example.myProject.MyIMBD.MovieService;
import com.example.myProject.MyIMBD.DAOs.MovieDAO;
import com.example.myProject.MyIMBD.Exception.MovieNotFound;
import com.example.myProject.MyIMBD.model.MovieModel;
import com.example.myProject.MyIMBD.model.PMovieModel;
import com.example.myProject.MyIMBD.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieDAO movieDAO;
    @Autowired
    Response response;
    public ResponseEntity<Response> addMovie(MovieModel movie){

        if(movie.getmId()!=null && movie.getmGenre()!=null && movie.getmName()!=null && movie.getmRatting()!=null &&
                    movie.getmPrimaryLanguage()!=null && movie.getmYearOfRelease()!=null && movie.getmListOfActors()!=null ){
             movieDAO.setmName(movie.getmName());
             movieDAO.setmGenre(movie.getmGenre());
             movieDAO.setmRatting(movie.getmRatting());
             movieDAO.setmListOfActors(movie.getmListOfActors());
             movieDAO.setmPrimaryLanguage(movie.getmPrimaryLanguage());
             movieDAO.setmYearOfRelease(movie.getmYearOfRelease());
             movieDAO.setmId(movie.getmId());
            response.setMessage("movie added successfully");
             return  new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            response.setMessage("please fill all movie details");
            return  new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }


    }
    public ResponseEntity<Response> completeUpdate(MovieModel model , String mName, String mYearOfRelease,Integer ratting)throws  MovieNotFound{

        if(mName.equals(movieDAO.getmName()) && mYearOfRelease.equals(movieDAO.getmYearOfRelease()) && ratting.equals(movieDAO.getmRatting())){
            movieDAO.setmName(model.getmName());
            movieDAO.setmYearOfRelease(model.getmYearOfRelease());
            movieDAO.setmRatting(model.getmRatting());
            movieDAO.setmGenre(model.getmGenre());
            movieDAO.setmPrimaryLanguage(model.getmPrimaryLanguage());
            movieDAO.setmListOfActors(model.getmListOfActors());
            response.setMessage("movie updated successfully");
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            throw new MovieNotFound("movie not found");
        }

    }
    public  ResponseEntity<Response> partialUpdate(PMovieModel model,String mName) throws  MovieNotFound{

        if(mName.equals(movieDAO.getmName())){
            movieDAO.setmGenre(model.getGenre());
            movieDAO.setmRatting(model.getRatting());
            movieDAO.setmPrimaryLanguage(model.getPrimaryLanguage());
            response.setMessage("partial updation successfully");
            response.setMovieDAO(movieDAO);
            return  new ResponseEntity<>(response,HttpStatus.OK);
        }else {
            throw new MovieNotFound("Movie not found");
        }
    }
    public  ResponseEntity<Response> deleteMovie(String mName, String mId) throws MovieNotFound{

        if(mName.equals(movieDAO.getmName())&& mId.equals(movieDAO.getmId())){
           movieDAO=null;
          response.setMessage("movie deleted successfully");
          return  new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            throw new MovieNotFound("movie not found");
        }
    }
    public ResponseEntity<Response> movie()throws MovieNotFound{
        if(movieDAO.getmName()!=null && movieDAO.getmId()!=null){
            response.setMessage("List of all movie");
            response.setMovieDAO(movieDAO);
            return  new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            throw new MovieNotFound("empty database");
        }

    }
    public  ResponseEntity<Response> updateRatting(String mName,Integer mRatting) throws MovieNotFound{
        if(mName.equals(movieDAO.getmName())){
            movieDAO.setmRatting(mRatting);
            response.setMessage("Movie ratting updated");
            response.setMovieDAO(movieDAO);
            return  new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            throw new MovieNotFound("Movie not found");
        }
    }
    public  ResponseEntity<Response> fetchbyGenre(String genre) throws MovieNotFound{
        if(genre.equals(movieDAO.getmGenre())){
            response.setMovieDAO(movieDAO);
            response.setMessage("list of movie by paritcular movie");
           return  new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            throw new MovieNotFound("Movie not found");
        }
    }
    public  ResponseEntity<Integer> rattingByMovie(String mName,String mid) throws  MovieNotFound{
        if(movieDAO.getmId ().equals ( mid ) && movieDAO.getmName ().equals ( mName )){
            return  new ResponseEntity<> ( movieDAO.getmRatting (),HttpStatus.OK );
        }else{
            throw new MovieNotFound ( "movie not found" );
        }
    }
    public ResponseEntity<Response> movieByRatting(Integer ratting) throws MovieNotFound{
        if(movieDAO.getmRatting ()<ratting){
            response.setMessage ( "list of movie by particular ratting" );
            response.setMovieDAO ( movieDAO );
            return  new ResponseEntity<> ( response,HttpStatus.OK );
        }else{
            throw  new MovieNotFound ( "movie not found for particular ratting" );
        }
    }
    public ResponseEntity<Response> moviebyGenreYear(String genre,String year) throws MovieNotFound{
        if(genre.equals ( movieDAO.getmGenre () )&& year.equals ( movieDAO.getmYearOfRelease () ) ){
            response.setMovieDAO ( movieDAO );
            response.setMessage ( "list of movie by particular genre and year of release" );
            return  new ResponseEntity<> ( response,HttpStatus.OK );
        }else{
            throw new MovieNotFound ( "movie not found" );
        }
    }
}

