package com.alkemy.challenge.services;

import java.io.IOException;
import java.util.List;

import com.alkemy.challenge.models.Character;
import com.alkemy.challenge.payload.response.MessageResponse;
import com.alkemy.challenge.repositories.CharacterRepo.ICharacterRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CharacterService {
    @Autowired
    private ICharacterRepository charRepo;

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

    public Iterable<Object> obtainAll(){
        return charRepo.obtainAll();
    }

    public Iterable<Character> findByName(String name){
        return charRepo.findByName(name);
    }

    public Iterable<Character> findByAge(Integer age){
        return charRepo.findByAge(age);
    }

    public List<Character> findAll(){
        return charRepo.findAll();
    }

    public Iterable<Character> findByAssociated_films(Long idMovie){
        return charRepo.findByAssociated_films(idMovie);
    } 


}
