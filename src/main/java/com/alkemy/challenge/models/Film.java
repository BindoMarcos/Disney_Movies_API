package com.alkemy.challenge.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table (name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilm;

    private String img;
    private String title;
    private Date creation_date;
    private Float qualification;
    
    @ManyToOne
    @JoinColumn(name = "idCharacter", nullable = false)
    private Character associated_character;

    @OneToMany(mappedBy = "associated_film")
    private Set<Genre> genres;
    
}
