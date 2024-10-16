package com.altair.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

import com.altair.curso.springboot.webapp.springboot_web.model.ParamsMixDto;
import com.altair.curso.springboot.webapp.springboot_web.model.dto.ParamsDto;
@RestController
@RequestMapping("/api/Params")
public class RequestParamsController {
    @GetMapping("/foo")
    public ParamsDto foo(@RequestParam (required = false, defaultValue = "Hola que tal",name = "menssaje" ) String menssage){

        ParamsDto params = new ParamsDto();
        params.setMenssage(menssage);
        return params;
    }
 
    @GetMapping ("/bar")
    public ParamsMixDto bar(@RequestParam String text, @RequestParam Integer code){
        ParamsMixDto params = new ParamsMixDto();
        params.setMenssage(text);
        params.setCode(code);
        return params;

    }
@GetMapping ("/request")
public ParamsMixDto requRequest (HttpServletRequest request){
    int code =10;
    try{
        code=Integer.parseInt(request.getParameter("code"));
    }catch (NumberFormatException e){
    } 
    ParamsMixDto params = new ParamsMixDto();
    params.setCode(code);
    params.setMenssage((request.getParameter("menssage")));
    return params;       
    
}
}

