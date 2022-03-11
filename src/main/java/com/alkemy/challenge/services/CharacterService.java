package com.alkemy.challenge.services;

import java.io.IOException;
import java.util.Optional;

import com.alkemy.challenge.models.Character;
import com.alkemy.challenge.payload.response.MessageResponse;
import com.alkemy.challenge.repositories.ICharacterRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CharacterService {
    @Autowired
    private ICharacterRepository charRepo;

    @Autowired
    private GenreService genreService;

    public Character save(String character, MultipartFile img) {
        Character entity = new Character();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            entity = objectMapper.readValue(character, Character.class);
            entity.setImg(img.getBytes());
            charRepo.save(entity);
        } catch (IOException e) {
            ResponseEntity.badRequest().body(new MessageResponse(e.toString()));
        }

        return entity;
    }

    public Character updateImg(String name, MultipartFile img) {
        Iterable<Character> entity = charRepo.findByName(name);
        try {
            entity.iterator().next().setImg(img.getBytes());
            charRepo.save(entity.iterator().next());
        } catch (Exception e) {
            ResponseEntity.badRequest().body(new MessageResponse(e.toString()));
        }

        return entity.iterator().next();
    }

    public Iterable<Object> obtainAll() {
        return charRepo.obtainAll();
    }

    public Iterable<Character> findByName(String name) {
        return charRepo.findByName(name);
    }

    public Iterable<Character> findByAge(Integer age) {
        return charRepo.findByAge(age);
    }

    public Iterable<Character> findPerMovie(Long id_character) {
        return charRepo.findPerMovie(id_character);
    }

    public ResponseEntity<MessageResponse> deletePerName(String name) {
        Iterable<Character> entity = charRepo.findByName(name);
        Long id = entity.iterator().next().getIdCharacter();
        ResponseEntity<MessageResponse> msg;
        try {
            genreService.deletePerId(id);
            charRepo.deletePerName(name);
            msg = ResponseEntity.ok().body(new MessageResponse(name + " deleted successfuly"));
        } catch (Exception e) {
            msg = ResponseEntity.badRequest().body(new MessageResponse(e.toString()));
        }

        return msg;
    }

    public Optional<Character> findById(Long id_character) {
        return charRepo.findById(id_character);
    }
}
