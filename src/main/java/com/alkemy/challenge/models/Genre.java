package com.alkemy.challenge.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGenre;

    @Column(nullable = false , length = 20)
    private String name;

    @OneToMany(mappedBy = "genreId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Film> filmsId;

    @Lob
    @Column(nullable = false)
    private byte[] img;

}
