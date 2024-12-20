package br.edu.multivix.pei.tolyid.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/hello")
@Tag(name = "Hello", description = "Controlador com endpoint público para teste, sendo útil para verificar se a API está online. Não exige autenticação.")
public class HelloController {

    @GetMapping
    @Operation(summary = "Mostra Mensagem Secreta", description = "Mostra uma mensagem secreta a fim de validar se a API está online.")
    public Message sayHello(){
        return new Message("Oi meu chapa!");
    }

    @Hidden
    private record Message(String message) {
    }

}