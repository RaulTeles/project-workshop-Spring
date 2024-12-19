package com.firstProjectRT.projectRT.resources;

import com.firstProjectRT.projectRT.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"Raul","telesraul@gmail.com","81986614229","1234");
            return ResponseEntity.ok().body(u);
    }

}
