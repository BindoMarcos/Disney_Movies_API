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

    @Query(value = "SELECT title, creation_date, img FROM films", nativeQuery = true)
    public Iterable<Object> getAll();

    @Modifying
    @Transactional
    @Query(value = "UPDATE films SET id_genre= NULL WHERE id_genre= :id_genre", nativeQuery = true)
    public void updateIdGenre(@Param("id_genre") Long id_genre);

    public Iterable<Film> findByTitle(String title);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM films WHERE title= :title", nativeQuery = true)
    public void deletePerName(@Param("title") String title);

    @Query(value = "SELECT * FROM films WHERE id_genre = :id_genre", nativeQuery = true)
    public Iterable<Film> findPerIdGenre(@Param("id_genre") Long id_genre);

    @Query(value = "SELECT * FROM films ORDER BY creation_date ASC", nativeQuery = true)
    public Iterable<Film> orderByAsc();

    @Query(value = "SELECT * FROM films ORDER BY creation_date DESC", nativeQuery = true)
    public Iterable<Film> orderByDesc();
}
