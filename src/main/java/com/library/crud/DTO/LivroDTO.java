package com.library.crud.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LivroDTO {

    public Long id;

    public String titulo;

    public String autor;

    public LivroDTO() {
    }

    public LivroDTO(Long id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
}
