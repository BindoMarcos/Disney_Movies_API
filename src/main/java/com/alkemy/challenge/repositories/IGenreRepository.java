package com.alkemy.challenge.repositories;

import com.alkemy.challenge.models.Genre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IGenreRepository extends JpaRepository<Genre, Long> {

    public Iterable<Genre> findByName(String name);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM genres WHERE name = :name", nativeQuery = true)
    public void deletePerName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM characters_movies WHERE id_character = :id_character", nativeQuery = true)
    public void deletePerId(@Param("id_character") Long id_character);


}
