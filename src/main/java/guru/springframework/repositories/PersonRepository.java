package guru.springframework.repositories;

import guru.springframework.models.Category;
import guru.springframework.models.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PersonRepository extends Neo4jRepository<Person, Long> {


    @Query ("MATCH (n:Person)-[:VIEWED]-(m:Movie) " +
            "WHERE id(m)= {movie_id}" +
            "RETURN n  ")
    List<Person> findByMovieId(@Param("movie_id") Long id);

    @Query ("MATCH (n:Person)-[:FRIEND]-(m:Person) " +
            "WHERE id(m)= {person_id}" +
            "RETURN n  ")
    List<Person> findByPersonId(@Param("person_id") Long id);


    @Query ("MATCH (n:Person) "+
            "WHERE NOT id(n)= {person_id}" +
            "RETURN n  ")
    List<Person> findByPeopleWithoutOneId(@Param("person_id") Long id);


}