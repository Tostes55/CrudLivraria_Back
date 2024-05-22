package com.library.crud.controller;

import com.library.crud.DTO.LivroDTO;
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
    public List<LivroDTO> buscaLivros(){return livroService.buscaLivros();
    }

    @PostMapping
    public void cadastrarLivro(@RequestBody LivroDTO livroDTO){livroService.cadastraLivro(livroDTO);}

    @PutMapping("/{id}")
    public void atualizaLivro(@RequestBody LivroDTO livroDTO,@PathVariable Long id ){livroService.atualizaLivro(livroDTO, id);}

    @DeleteMapping("/{id}")
    public void apagaLivro(@PathVariable Long id){livroService.apagaLivro(id);}



}
