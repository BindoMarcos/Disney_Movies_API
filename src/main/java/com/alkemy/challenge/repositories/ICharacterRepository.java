package com.alkemy.challenge.repositories;

import com.alkemy.challenge.models.Character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ICharacterRepository extends JpaRepository<Character, Long> {

    @Query(value = "SELECT name, img FROM characters ", nativeQuery = true)
    public Iterable<Object> obtainAll();

    public Iterable<Character> findByName(String name);

    public Iterable<Character> findByAge(Integer age);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM characters WHERE name = :name", nativeQuery = true)
    void deletePerName(@Param("name") String name);


    //To-Do
    @Query(value = "SELECT * FROM characters INNER JOIN characters_movies WHERE idMovie = :idMovie", nativeQuery = true)
    public Iterable<Character> findPerMovie(@Param("idMovie") Long idMovie);

}
