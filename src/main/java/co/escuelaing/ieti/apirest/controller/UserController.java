package co.escuelaing.ieti.apirest.controller;

import co.escuelaing.ieti.apirest.service.UserService;
import co.escuelaing.ieti.apirest.dto.UserDTO;
import co.escuelaing.ieti.apirest.data.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "v1/user" )
public class UserController {
    private final UserService userService;

    public UserController(@Autowired UserService userService){
        this.userService = userService;
    }

    @GetMapping
     public ResponseEntity<List<User>> all()
     {
         return ResponseEntity.status(HttpStatus.OK).body(userService.all());
     }
     
     @GetMapping( "/{id}" )
     public ResponseEntity<User> findById( @PathVariable String id )
     {
        //TODO implement this method using UserService
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
     }
     
     @PostMapping
     public ResponseEntity<User> create( @RequestBody UserDTO userDTO )
     {
        try 
        {
            return ResponseEntity.status(HttpStatus.OK).body(userService.create(new User(userDTO)));
        } catch (Exception e) 
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
          //TODO implement this method using UserService
     }
     
     @PutMapping( "/{id}" )
     public ResponseEntity<User> update( @RequestBody UserDTO userDTO, @PathVariable String id )
     {
        try 
        {
            return ResponseEntity.status(HttpStatus.OK).body(userService.update(new User(userDTO),id));
        } catch (Exception e) 
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
     }

     @DeleteMapping( "/{id}" )
     public ResponseEntity<Boolean> delete( @PathVariable String id )
     {
         try 
        {   userService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(true);
        } catch (Exception e) 
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }     
     }
}
