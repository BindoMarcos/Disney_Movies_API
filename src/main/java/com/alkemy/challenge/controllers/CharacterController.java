package com.alkemy.challenge.controllers;

import java.util.Optional;

import com.alkemy.challenge.models.Character;
import com.alkemy.challenge.payload.response.MessageResponse;
import com.alkemy.challenge.services.CharacterService;

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
@RestController
@PreAuthorize("hasRole('USER')")
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService charService;

    // 3- Listado de personajes
    @GetMapping("")
    public Iterable<Object> obtainAll() {
        return charService.obtainAll();
    }

    // 4- CRUD
    // Save Character
    @PostMapping(path = "", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public Character saveChar(@RequestPart("character") String entity, @RequestPart("img") MultipartFile img) {
        return charService.save(entity, img);
    }

    // Update Image
    @PutMapping(path = "/update", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public Character updateImage(@RequestPart("name") String name, @RequestPart("img") MultipartFile img) {
        return charService.updateImg(name, img);
    }

    // Borrado de personaje
    @DeleteMapping("/delete/{name}")
    public ResponseEntity<MessageResponse> deletePerName(@PathVariable String name) {
        return charService.deletePerName(name);
    }
    // <-----FIN CRUD----->

    // 5- Detalle de Personaje
    @GetMapping(params = "id_character")
    public Optional<Character> findById(@RequestParam Long id_character) {
        return charService.findById(id_character);
    }

    // 6- Busqueda de Personajes
    @GetMapping(params = "name")
    public Iterable<Character> findByName(@RequestParam String name) {
        return charService.findByName(name);
    }

    @GetMapping(params = "age")
    public Iterable<Character> findByAge(@RequestParam Integer age) {
        return charService.findByAge(age);
    }

    @GetMapping("/{id_character}") // REVISAR
    public Iterable<Character> findByMovies(@PathVariable Long id_character) {
        return charService.findPerMovie(id_character);
    }
    // Fin Busqueda de Personajes

}