package br.edu.multivix.pei.tolyid.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/hello")
@Tag(name = "Hello", description = "Controlador com endpoint público para teste, sendo útil para verificar se a API está online. Não exige autenticação.")
public class HelloController {

    @GetMapping
    public String sayHello(){
        return "Oi meu chapa!";
    }

}