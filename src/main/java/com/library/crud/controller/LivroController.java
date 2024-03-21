package com.library.crud.controller;

import com.library.crud.model.Livro;
import com.library.crud.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> buscaLivros(){return livroService.buscaLivros();
    }

    @PostMapping
    public void cadastrarLivro(@RequestBody Livro livro){livroService.cadastraLivro(livro);}

    @PutMapping("/{id}")
    public void atualizaLivro(@RequestBody Livro livro,@PathVariable Long id ){livroService.atualizaLivro(livro, id);}

    @DeleteMapping("/{id}")
    public void apagaLivro(@PathVariable Long id){livroService.apagaLivro(id);}



}
