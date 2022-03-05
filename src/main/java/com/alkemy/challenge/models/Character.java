package com.alkemy.challenge.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "characters")
public class Character {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCharacter;

    private String img; //See how to upload an image
    private String name;
    private int age;
    private Float weigth;
    private String history;

    @OneToMany(mappedBy = "associated_character")
    private Set<Film> associated_films;
}
