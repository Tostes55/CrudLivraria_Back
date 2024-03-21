package com.library.crud.service;

import com.library.crud.model.Livro;
import com.library.crud.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {this.livroRepository = livroRepository;
    }

    public List<Livro> buscaLivros(){return livroRepository.findAll();
    }

    public void cadastraLivro(Livro livro){livroRepository.save(livro); }

    public void atualizaLivro(Livro livro, Long id){
        livro.id=id;
        livroRepository.save(livro);}

    public void apagaLivro(Long id){
        livroRepository.deleteById(id);
    }


}
