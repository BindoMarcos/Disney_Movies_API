package com.alkemy.challenge.repositories;

import com.alkemy.challenge.models.Film;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IFilmRepository extends JpaRepository<Film, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE films SET id_genre= NULL WHERE id_genre= :id_genre", nativeQuery = true)
    public void updateIdGenre(@Param("id_genre")Long id_genre);
}
