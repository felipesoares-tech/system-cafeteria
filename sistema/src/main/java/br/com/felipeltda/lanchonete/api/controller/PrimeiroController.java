package br.com.felipeltda.lanchonete.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PrimeiroController {
    @GetMapping("/oi")
    @ResponseBody
    public String hello(){
        return "Oi, tudo bem?";
    }
}
