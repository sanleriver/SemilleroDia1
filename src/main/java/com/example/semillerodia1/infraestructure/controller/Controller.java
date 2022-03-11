package com.example.semillerodia1.infraestructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public String getProducts(){
        return "Este es el método para consultar todos los productos";
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public String postProducts(){
        return "Este es el método para crear un producto";
    }

    @RequestMapping(path = "/products", method = RequestMethod.PUT)
    public String putProducts(){
        return "Este es el método para actualizar un producto";
    }

    @RequestMapping(path = "/products", method = RequestMethod.DELETE)
    public String deleteProducts(){
        return "Este es el método para eliminar un producto";
    }

}
