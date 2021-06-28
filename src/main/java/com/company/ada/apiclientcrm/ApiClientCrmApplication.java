package com.company.ada.apiclientcrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//1 RO QUE SE HACE
@SpringBootApplication
//@RestController
//Buscador con tecla shift(x2)
public class ApiClientCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiClientCrmApplication.class, args);
    }

/*    @GetMapping
    public String saludar(){
        return "<h1>Hola mundo</h1><hr/>bye!";
    }*/
}
