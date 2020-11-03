package com.example.demo2.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo2.modelos.Autor;

public interface AutorRepositorio extends CrudRepository <Autor, Integer> {

}
