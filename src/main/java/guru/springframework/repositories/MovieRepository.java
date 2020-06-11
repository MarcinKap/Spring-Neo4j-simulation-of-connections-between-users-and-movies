package guru.springframework.repositories;

import guru.springframework.models.Movie;

import guru.springframework.models.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    @Query("MATCH (n:Movie)-[:VIEWED]-(m:Person) " +
            "WHERE id(m)= {person_id}" +
            "RETURN n  ")
    List<Movie> findByPersonId(@Param("person_id") Long id);



//    Wyszukuje filmy obejrzane przez osobe2
//    Wyszukuje filmy obejrzane przez osobe1
//    Definiuje że osoba P2 to kumpel P1
//    Znajduje Kategorie C2 i C1
    @Query("MATCH " +
            "(n2:Movie)-[:VIEWED]-(p2:Person)," +
            "(n1:Movie)-[:VIEWED]-(p1:Person)," +
            "(p1:Person)-[:FRIEND]-(p2:Person)," +
            "(c2:Category)-[:MOVIE_TYPE]-(n2:Movie)," +
            "(c1:Category)-[:MOVIE_TYPE]-(n1:Movie)"+

            "WHERE NOT (p1)-[:VIEWED]-(n2) AND c1=c2 AND  id(p1)= {person_id} " +
            "RETURN n2 ")
    List<Movie> findSuggestedMovies(@Param("person_id") Long id);



}
