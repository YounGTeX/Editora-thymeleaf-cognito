package com.editora.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.editora.demo.entity.Artigo;
import com.editora.demo.repository.ArtigoRepository;

@RestController
@RequestMapping("/api/artigos")
public class ArtigoController {
  @Autowired
  private ArtigoRepository _artigoRepository;

  @PostMapping() // CRIAR
  public ModelAndView createArtigo(Artigo art) {
    ModelAndView modelCA = new ModelAndView("post"); 
    Artigo _art = _artigoRepository.save(art);
    modelCA.addObject("artigo", _art);
    modelCA.addObject("artigos", _artigoRepository.findAll());
    return modelCA;
}


  @GetMapping() // LISTAR TODOS
  public ModelAndView buscarAllArtigos() {
    ModelAndView modelL = new ModelAndView("lista");
		Iterable<Artigo> artigoIt = _artigoRepository.findAll();
		modelL.addObject("artigos", artigoIt);
		return modelL;
}

  @GetMapping("/{id}") // RECUPERAR POR ID
  public ModelAndView getByID(@PathParam("id") String id) {
    long value1 = Long.parseLong(id);
    ModelAndView modelB = new ModelAndView("buscaId");
		Optional<Artigo> artigoId = _artigoRepository.findById(value1);
		modelB.addObject("artigos", artigoId.get());
		return modelB;
}
  // public ResponseEntity<Artigo> GetById(@PathParam("id") String id) {
  //   long value1 = Long.parseLong(id);
  //   Optional<Artigo> artigo = _artigoRepository.findById(value1);
  //   if(artigo.isPresent())
  //     return new ResponseEntity<Artigo>(artigo.get(), HttpStatus.OK);
  //   else
  //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  // }

  @PutMapping("/{id}") // ATUALIZAR POR ID
  public ModelAndView editById(@PathParam("id") String id, Artigo newArtigo) {
    long value1 = Long.parseLong(id);
    ModelAndView modelEd = new ModelAndView("edit");
    Optional<Artigo> oldArtigo = _artigoRepository.findById(value1);
    Artigo artigo = oldArtigo.get();
      artigo.setTitulo(newArtigo.getTitulo());
      artigo.setResumo(newArtigo.getResumo());
      artigo.setStatus(newArtigo.getStatus());
		modelEd.addObject("artigos", artigo);
		return modelEd;
}
  // public ResponseEntity<Artigo> Put(@PathParam("id") long id, Artigo newArtigo) {
  //   Optional<Artigo> oldArtigo = _artigoRepository.findById(id);
  //   if (oldArtigo.isPresent()) {
  //     Artigo artigo = oldArtigo.get();

  //     artigo.setTitulo(newArtigo.getTitulo());
  //     artigo.setResumo(newArtigo.getResumo());
  //     artigo.setStatus(newArtigo.getStatus());

  //     _artigoRepository.save(artigo);
  //     return new ResponseEntity<Artigo>(artigo, HttpStatus.OK);
  //   }
  //   else
  //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  // }

  @DeleteMapping("/{id}") // DELETAR POR ID
  public ModelAndView excluirArtigo(@PathVariable("id") String id) {
    ModelAndView modelD = new ModelAndView("delete");
		long value1 = Long.parseLong(id);
		_artigoRepository.deleteById(value1);
		return modelD;
	}
  // public ResponseEntity<Object> DeleteById(@PathParam("id") long id) {
  //   Optional<Artigo> artigo = _artigoRepository.findById(id);
  //   if(artigo.isPresent()){
  //     _artigoRepository.delete(artigo.get());
  //     return new ResponseEntity<>(HttpStatus.OK);
  //   }
  //   else
  //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  // }

  @DeleteMapping() // LISTAR TODOS OS ARTIGOS PUBLICADOS
  public ModelAndView listarTodosArtigosPublicados() {
    ModelAndView modelD = new ModelAndView("lista");
    Iterable<Artigo> artigoIt = _artigoRepository.findPublished();
		modelD.addObject("artigos", artigoIt);
		return modelD;
	}

  @GetMapping("/publicados") // DELETAR TODOS OS ARTIGOS
  public ModelAndView excluirTodosArtigos() {
    ModelAndView modelL = new ModelAndView("delete");
    _artigoRepository.deleteAll();
		return modelL;
}
}