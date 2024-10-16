package com.altair.curso.springboot.webapp.springboot_web.controllers;


//import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.altair.curso.springboot.webapp.springboot_web.model.User;
import com.altair.curso.springboot.webapp.springboot_web.model.dto.UserDto;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")

public class UserRestControllers {

    @GetMapping (path="/detalls")
     public UserDto detalls(){
        
       User user = new User("Altair", "Aké");

       UserDto userDto = new UserDto();
       userDto.setUser(user);
       userDto.setTitle("Hola  mundo Spring Boot");
           
        return userDto;

    }


@GetMapping("/List")
public List<User>list(){
 

    User user = new User("Altaír", "Aké");
    User user2 = new User("Pepe", "doe");
    User user3 = new User("Juan", "doe");

    List<User> users = Arrays.asList(user,user2,user3);
      //List<User> users = new ArrayList<>();
      // users.add(user);
      //users.add(user2);
      //users.add(user3);
    return users;

}
    
    @GetMapping (path="/detalls-Map")

    public Map<String,Object> detallsMap(){

       User user = new User("Altair", "Aké");
       Map<String, Object> body = new HashMap<>();

       body.put("title", "Hola Mundo Spring Boot");
       body.put("user", user);
           return body;

    }




}

