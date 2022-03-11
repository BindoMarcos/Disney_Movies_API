package com.alkemy.challenge.controllers;

import java.util.Optional;

import com.alkemy.challenge.models.Film;
import com.alkemy.challenge.payload.response.MessageResponse;
import com.alkemy.challenge.services.FilmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", maxAge = 3600)
@PreAuthorize("hasRole('USER')")
@RestController
@RequestMapping("/movies")
public class FilmController {

    @Autowired
    private FilmService filmService;

    // 7- Listado de Peliculas/series
    @GetMapping("")
    public Iterable<Object> getAll() {
        return filmService.getAll();
    }

    // 8- Detalle de Pelicula/serie
    @GetMapping(params = "id_film")
    public Optional<Film> findById(Long id_film) {
        return filmService.findById(id_film);
    }

    // 9- CRUD
    // Save Film
    @PostMapping(path = "", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public Film saveFilm(@RequestPart("film") String entity, @RequestPart("img") MultipartFile img) {
        return filmService.save(entity, img);
    }

    // Update Image
    @PutMapping(path = "/update", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public Film updateImg(@RequestPart("title") String title, @RequestPart("img") MultipartFile img) {
        return filmService.updateImg(title, img);
    }

    // Delete Film
    @DeleteMapping("/delete/{title}")
    public ResponseEntity<MessageResponse> deleteByName(@PathVariable String title) {
        return filmService.deletePerName(title);
    }

    // <-----FIN CRUD----->

    // 10- Busqueda, filtro y ordenacion
    @GetMapping(params = "title")
    public Iterable<Film> findByTitle(@RequestParam String title) {
        return filmService.findByTitle(title);
    }

    @GetMapping(params = "id_genre")
    public Iterable<Film> findByidGenre(@RequestParam Long id_genre) {
        return filmService.findByGenre(id_genre);
    }

    @GetMapping(params = "order")
    public Iterable<Film> selectByOrder(@RequestParam String order) {
        return filmService.selectByOrder(order);
    }
}
