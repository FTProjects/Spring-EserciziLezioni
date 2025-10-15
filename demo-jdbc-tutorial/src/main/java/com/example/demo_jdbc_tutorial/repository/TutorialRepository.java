package com.example.demo_jdbc_tutorial.repository;

import com.example.demo_jdbc_tutorial.model.Tutorial;

import java.util.List;

public interface TutorialRepository {

    //CREATE
    int save(Tutorial tutorial);

    //UPDATE
    int update(Tutorial tutorial);

    //READ
    Tutorial findById(Long id);

    //READ
    List<Tutorial> findAll();

    //READ
    List<Tutorial> findByPublished(boolean published);

    //READ
    List<Tutorial> findByCategory(String category);

    //READ
    List<Tutorial> findAllByTitleContaining(String title);

    //DELETE
    int deleteById(Long id);

    //DELETE
    int deleteAll();
}
