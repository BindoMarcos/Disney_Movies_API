package com.alkemy.challenge.controllers;

import java.util.List;

import com.alkemy.challenge.models.Character;
import com.alkemy.challenge.services.CharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping(path = "", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public Character savejson(@RequestPart("character") String entity, @RequestPart("img") MultipartFile img) {
        Character jsonchar = charService.save(entity, img);
        return jsonchar;
    }

    @GetMapping("")
    public Iterable<Object> obtainAll(){
        return charService.obtainAll();
    }

    @GetMapping(params = "name")
    public Iterable<Character> findByName(@RequestParam String name){
        return charService.findByName(name);
    }

    @GetMapping(params = "age")
    public Iterable<Character> findByAge(@RequestParam Integer age){
        return charService.findByAge(age);
    }

    @GetMapping(params = "associated_films")
    @PreAuthorize("hasRole('USER')")
    public Iterable<Character> findByMovies(@RequestParam Long idMovie){
        return charService.findByAssociated_films(idMovie);
    } 

    @GetMapping("/getAll")
    public List<Character> findAll(){
        return charService.findAll();
    }

}