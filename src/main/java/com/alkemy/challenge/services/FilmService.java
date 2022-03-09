package com.alkemy.challenge.services;

import com.alkemy.challenge.repositories.IFilmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
    @Autowired
    private IFilmRepository filmRepo;


    public void updateIdGenre(Long id_genre){
        filmRepo.updateIdGenre(id_genre);
    }
}
