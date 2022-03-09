package com.alkemy.challenge.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilm;

    @Column(nullable = false, length = 40)
    private String title;
    @Column(nullable = false)
    private Date creation_date;
    @Column(nullable = false)
    private Float qualification;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "filmsId", cascade = CascadeType.ALL)
    private List<Character> charactersID;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idGenre")
    private Genre genreId;

    @Lob
    @Column(nullable = false)
    private byte[] img;
}
