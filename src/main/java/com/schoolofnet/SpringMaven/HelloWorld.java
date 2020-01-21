package com.schoolofnet.SpringMaven;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/")
public class HelloWorld {

    @GetMapping
    public String sayHello(){
        return "Hello from SpringBoot by Paulo";
    }

    @GetMapping("/subpath")
    @ResponseBody
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public String subPath(final WebRequest webRequest){
        String name = webRequest.getParameter("name");
        if(name != null){
            return "Esta é a pagina do subpath " + name;
        } 
            return "Não achou nada";
    }

    @GetMapping("/teste")
    public String teste(){
        return "teste de pagina";
    }

    @GetMapping("/{dynamic}")
    public String dynamicSubPatj(@PathVariable("dynamic") String name){
        return "Hello teste " + name + " Teste de rota";
    }

    @PostMapping("/post")
    public String sayHelloPost(@RequestBody Map<String, Object> payload){
        return payload.get("name").toString();
    }

    
    
    

    
}