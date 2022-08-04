package com.editora.demo.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;

import com.editora.demo.entity.Artigo;
import com.editora.demo.repository.ArtigoRepository;

@Controller
public class HomeController {
    @Autowired
    private ArtigoRepository _artigoRepository;
  
    @GetMapping("/")
    public String index(Authentication a) {
        System.out.println("CREDENCIAIS: " + a);
        if (a != null) {
            return "index.html";
        }
        return "redirect:oauth2/authorization/cognito";
    }
    
}