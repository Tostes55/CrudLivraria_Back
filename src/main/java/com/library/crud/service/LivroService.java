package com.library.crud.service;

import com.library.crud.DTO.LivroDTO;
import com.library.crud.model.Livro;
import com.library.crud.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {this.livroRepository = livroRepository;
    }

    public List<LivroDTO> buscaLivros(){
        List<Livro> listaLivrosEncontrados = livroRepository.findAll();
        return converterListaLivroParaListaLivroDTO(listaLivrosEncontrados);
    }

    public void cadastraLivro(LivroDTO livroDTO){
        Livro livro = converteLivroDTOParaLivro(livroDTO);
        livroRepository.save(livro);
    }

    public void atualizaLivro(LivroDTO livroDTO, Long id){
        Livro livro = converteLivroDTOParaLivro(livroDTO);
        livro.id=id;
        livroRepository.save(livro);
    }

    public void apagaLivro(Long id){
        livroRepository.deleteById(id);
    }

    public LivroDTO converteLivroParaLivroDTO(Livro livro){

        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livro.id);
        livroDTO.setAutor(livro.autor);
        livroDTO.setTitulo(livro.titulo);

        return livroDTO;
    }

    public List<LivroDTO> converterListaLivroParaListaLivroDTO(List<Livro> listaDeLivros){
        return listaDeLivros.stream().map(this::converteLivroParaLivroDTO).collect(Collectors.toList());
    }

    public Livro converteLivroDTOParaLivro(LivroDTO livroDTO){
        Livro livro = new Livro();
        livro.setId(livroDTO.id);
        livro.setAutor(livroDTO.autor);
        livro.setTitulo(livroDTO.titulo);

        return livro;
    }

}
