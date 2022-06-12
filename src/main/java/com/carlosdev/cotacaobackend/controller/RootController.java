package com.carlosdev.cotacaobackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class RootController {


    @GetMapping("/status")
    public String hello() {
        return String.format("acesso em: %s", new Date());
    }
}