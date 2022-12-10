package com.example.proyIntegradorFinal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPruebaLogin {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/auth")
    public String sayHelloToUser(){
        return "hello user";
    }


}
