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

    // @GetMapping("/artigos")
    // public String listArtigos(Authentication a, Artigo artigo, @RequestParam(required = false) String titulo, Model model) {
    //     if (a != null) {
    //         try {
    //             List<Artigo> listArt = new ArrayList<Artigo>();
    //             if (titulo == null) {
    //                 _artigoRepository.findAll().forEach(listArt::add);
    //               }
    //             else
    //                 _artigoRepository.findByKeyword(titulo).forEach(listArt::add);
    //             if (listArt.isEmpty())
    //                 return "index.html";

    //             model.addAttribute("artigo", artigo);
    //             model.addAttribute("artigos", listArt);
    //             return "inteface.html";
    //         } catch (Exception e) {
    //             return "index.html";
    //         }
    //     }
    //     return "index.html";
    // }

    // @PostMapping("/")    
    // public String createArtigo(@RequestBody Artigo artigo, BindingResult result)
    // {   
    //     if(result.hasFieldErrors() || result.hasErrors()){
    //         System.out.println("Existem erros em HomeController.createArtigo()");
    //     }

    //     try {
    //         Artigo _a = _artigoRepository.save(new Artigo(artigo.getTitulo(), artigo.getResumo(), artigo.getStatus()));

    //         return "redirect:/api/artigos";
            
    //     } catch (Exception e) {
    //         return "redirect:/api/artigos";
    //     }

    // }
    
}