package com.library.crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LIVRO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long id;

    @Column(name = "TITULO")
    public String titulo;

    @Column(name = "AUTOR")
    public String autor;



}
