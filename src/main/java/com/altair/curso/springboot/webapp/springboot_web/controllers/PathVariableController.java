package com.altair.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altair.curso.springboot.webapp.springboot_web.model.User;
import com.altair.curso.springboot.webapp.springboot_web.model.dto.ParamsDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;


@RestController

@RequestMapping("/api/var")
public class PathVariableController {

    @Value("$(config.username)")
    private String username;

    @Value("$(config.menssage)")
    private String menssage;

    @Value("$(config.listOfValues)")
    private String listOfValues;

    @Value("$(config.code)")
    private String code;

    @Value("#{ '${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valuesList;
  
    @Value("#{ '${config.listOfValues}'.toUpperCase()}")
    private String valueString;

    @Value("#{ '${config.valuesMap}'}")
    private Map<String, Object> valuesMap;

    @Value("#{ '${config.valuesMap}.product'}")
    private String product;

    @Value("#{ '${config.valuesMap}.price'}")
    private String price;

    @Autowired
    private Environment environment;

    @GetMapping("/baz/{menssage}")
    public ParamsDto baz(@PathVariable String menssage){

        ParamsDto params = new ParamsDto();
        params.setMenssage(menssage);
        return params;
    }
    

  @GetMapping("/mix/{product}/{id}")
  public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id){
    
    Map<String, Object> json = new HashMap<>();
    json.put("product", product);
    json.put("id",id);

    return json;
}


    @PostMapping("/create")
    public User  create (@RequestBody User user){
      user.setName(user.getName().toUpperCase());
        return user;
    }


@GetMapping("/values")
     public Map<String, Object> values(@Value("config.menssage")String menssage) {

 Map<String, Object> json =  new HashMap<>();
 json.put("username",username);
 json.put("code",code);
 json.put("menssage",menssage);
 json.put("menssage2",environment.getProperty("config.menssage"));
 json.put("code2",environment.getRequiredProperty("config.code"));
 json.put("listOfVales",listOfValues);
 json.put("valueString",valueString);
 json.put("valueList",valuesList);
 json.put("valueMap",valuesMap);
 json.put("product",product);
 json.put("price",price);
 return json;}
}
