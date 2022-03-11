package com.alkemy.challenge.services;

import java.io.IOException;
import java.util.Optional;

import com.alkemy.challenge.models.Film;
import com.alkemy.challenge.payload.response.MessageResponse;
import com.alkemy.challenge.repositories.IFilmRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilmService {
    @Autowired
    private IFilmRepository filmRepo;

    public Film save(String film, MultipartFile img) {
        Film entity = new Film();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            entity = objectMapper.readValue(film, Film.class);
            entity.setImg(img.getBytes());
            filmRepo.save(entity);
        } catch (IOException e) {
            ResponseEntity.badRequest().body(new MessageResponse(e.toString()));
        }

        return entity;
    }

    public Film updateImg(String title, MultipartFile img) {
        Iterable<Film> entity = filmRepo.findByTitle(title);
        try {
            entity.iterator().next().setImg(img.getBytes());
            filmRepo.save(entity.iterator().next());
        } catch (Exception e) {
            ResponseEntity.badRequest().body(new MessageResponse(e.toString()));
        }

        return entity.iterator().next();
    }

    public Iterable<Object> getAll() {
        return filmRepo.getAll();
    }

    public Optional<Film> findById(Long id_film) {
        return filmRepo.findById(id_film);
    }

    public ResponseEntity<MessageResponse> deletePerName(String title) {
        ResponseEntity<MessageResponse> msg;
        try {
            filmRepo.deletePerName(title);
            msg = ResponseEntity.ok().body(new MessageResponse(title + " deleted successfuly"));
        } catch (Exception e) {
            msg = ResponseEntity.badRequest().body(new MessageResponse(e.toString()));
        }
        return msg;
    }

    public Iterable<Film> findByTitle(String title) {
        return filmRepo.findByTitle(title);
    }

    public Iterable<Film> findByGenre(Long id_genre) {
        // Long id_genre =
        // genreService.findByName(genre).iterator().next().getIdGenre();
        return filmRepo.findPerIdGenre(id_genre);

    }

    public void updateIdGenre(Long id_genre) {
        filmRepo.updateIdGenre(id_genre);
    }

    public Iterable<Film> selectByOrder(String order) {
        String newOrder = order.trim().toUpperCase();
        Iterable<Film> operation = null;
        if (newOrder.equals("ASC")) {
            operation = filmRepo.orderByAsc();
        } else if (newOrder.equals("DESC")) {
            operation = filmRepo.orderByDesc();
        }

        return operation;
    }
}
