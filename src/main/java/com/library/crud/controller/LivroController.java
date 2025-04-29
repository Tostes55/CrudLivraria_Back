package com.library.crud.controller;

import com.library.crud.DTO.LivroDTO;
import com.library.crud.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<LivroDTO> buscaLivros(){return livroService.buscaLivros();
    }

    @PostMapping
    public ResponseEntity<String> cadastrarLivro(@RequestBody LivroDTO livroDTO) {
        livroService.cadastraLivro(livroDTO);
        return new ResponseEntity<>("Livro Cadastrado com Sucesso", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizaLivro(@RequestBody LivroDTO livroDTO, @PathVariable Long id){livroService.atualizaLivro(livroDTO,id);
        return new ResponseEntity<>("Livro Atualizado com Sucesso", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    //public void apagaLivro(@PathVariable Long id){livroService.apagaLivro(id);}
    public ResponseEntity<String> apagaLivro(@PathVariable Long id){livroService.apagaLivro(id);
        return new ResponseEntity<>("Livro removido com sucesso", HttpStatus.NO_CONTENT);
    }


}
