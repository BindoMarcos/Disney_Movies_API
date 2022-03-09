package com.alkemy.challenge.controllers;

import java.util.Optional;

import com.alkemy.challenge.models.Genre;
import com.alkemy.challenge.payload.response.MessageResponse;
import com.alkemy.challenge.services.GenreService;

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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('USER')")
@RequestMapping("/genres")
public class GenderController {

    @Autowired
    private GenreService genreService;

    @PostMapping(path = "", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public Genre saveGenre(@RequestPart("genre") String entity, @RequestPart("img") MultipartFile img) {
        return genreService.save(entity, img);
    }

    @PutMapping(path = "/update", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public Genre updateImg(@RequestPart("name") String name, @RequestPart("img") MultipartFile img) {
        return genreService.updateImg(name, img);
    }

    @GetMapping(params = "id_genre")
    public Optional<Genre> findById(Long id_genre){
        return genreService.findById(id_genre);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<MessageResponse> deletePerName(@PathVariable String name){
        return genreService.deletePerName(name);
    }

}
