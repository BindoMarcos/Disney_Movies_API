package com.alkemy.challenge.repositories.CharacterRepo;

import java.util.Set;

import com.alkemy.challenge.models.Character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterRepository extends JpaRepository<Character, Long> {

    @Query(value = "SELECT name, img FROM `characters`;", nativeQuery = true)
    public Iterable<Object> obtainAll();

    public Iterable<Character> findByName(String name);
    public Iterable<Character> findByAge(Integer age);

    @Query(value = "SELECT (id_character) from 'characters_movies' ")
    public Set<Character> findByAssociated_films(Long idMovie);

}
