package com.altair.curso.springboot.webapp.springboot_web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

//import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
//import java.util.ArrayList;

import com.altair.curso.springboot.webapp.springboot_web.model.User;

@Controller

public class UserControllers {

    @GetMapping ("/detalls")
    public  String detalls(Model model){
        User user = new User("Altair", "Aké");
         model.addAttribute("title", "Hola Mundo Spring Boot");
          model.addAttribute("user",user);
           return "detalls";

    }

    @GetMapping("/list")
    public String list(ModelMap  model){
        List<User> users =  Arrays.asList(
        new User("pepe", "Gonzales"),
        new User("lala", "Perez"),
        new User("Juanita", "Perez","juanita@.com"),
        new User("andrez", "Perez","andrez@.com"));
        
        model.addAttribute("users", users);
        model.addAttribute("title","Listado de usuario!");
        return "list";
      }
    }

