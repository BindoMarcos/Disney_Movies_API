package com.alkemy.challenge.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;

@Data
@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCharacter;

    @Column(nullable = false, length = 40)
    private String name;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private Float weight;
    @Column(nullable = false)
    private String history;

    @JsonIgnore 
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "characters_movies", joinColumns = {
            @JoinColumn(name = "idCharacter", nullable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "idFilm", nullable = false) })
    private Set<Film> filmsId;

    @Lob
    @Column(nullable = false)
    private byte[] img;

}
