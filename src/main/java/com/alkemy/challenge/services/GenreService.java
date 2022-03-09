package com.alkemy.challenge.services;

import java.io.IOException;
import java.util.Optional;

import com.alkemy.challenge.models.Genre;
import com.alkemy.challenge.payload.response.MessageResponse;
import com.alkemy.challenge.repositories.IGenreRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GenreService {

    @Autowired
    private IGenreRepository genreRepo;

    @Autowired
    private FilmService filmService;

    public Genre save(String genre, MultipartFile img) {
        Genre entity = new Genre();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            entity = objectMapper.readValue(genre, Genre.class);
            entity.setImg(img.getBytes());
            genreRepo.save(entity);
        } catch (IOException e) {
            ResponseEntity.badRequest().body(new MessageResponse(e.toString()));
        }

        return entity;
    }

    public Genre updateImg(String name, MultipartFile img) {
        Iterable<Genre> entity = genreRepo.findByName(name);
        try {
            entity.iterator().next().setImg(img.getBytes());
            genreRepo.save(entity.iterator().next());
        } catch (Exception e) {
            ResponseEntity.badRequest().body(new MessageResponse(e.toString()));
        }

        return entity.iterator().next();
    }

    public Optional<Genre> findById(Long id_genre) {
        return genreRepo.findById(id_genre);
    }

    public void deletePerId(Long id_character) {
        genreRepo.deletePerId(id_character);
    }

    public ResponseEntity<MessageResponse> deletePerName(String name) {
        Long id_genre = genreRepo.findByName(name).iterator().next().getIdGenre();
        ResponseEntity<MessageResponse> msg;
        try {
            filmService.updateIdGenre(id_genre);
            genreRepo.deletePerName(name);
            msg = ResponseEntity.ok().body(new MessageResponse(name + " deleted successfuly"));
        } catch (Exception e) {
            msg = ResponseEntity.badRequest().body(new MessageResponse(e.toString()));
        }
        return msg;
    }

}
