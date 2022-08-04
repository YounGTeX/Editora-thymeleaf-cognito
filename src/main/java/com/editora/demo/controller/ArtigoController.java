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

  @GetMapping("/editar/{id}{titulo}{resumo}") // ATUALIZAR POR ID
  public ModelAndView editById(@PathParam("id") String id,@PathParam("titulo") String titulo,@PathParam("resumo") String resumo /*Artigo newArtigo*/) {
    long value1 = Long.parseLong(id);
    System.out.println(id);
    ModelAndView modelEd = new ModelAndView("edit");
    Optional<Artigo> oldArtigo = _artigoRepository.findById(value1);
    Artigo artigo = oldArtigo.get();
      artigo.setTitulo(titulo);
      artigo.setResumo(resumo);
      _artigoRepository.save(artigo);
		  modelEd.addObject("artigos", artigo);
      return modelEd;
}

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

@GetMapping("/publicados/{id}") // DELETAR POR ID
public ModelAndView excluirArtigo(@PathParam("id") String id) {
  long value1 = Long.parseLong(id);
  ModelAndView modelD1 = new ModelAndView("delete");
  _artigoRepository.deleteById(value1);
  return modelD1;
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
}