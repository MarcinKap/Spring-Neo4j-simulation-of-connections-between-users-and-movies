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

    @Query("MATCH (n:Movie)" +
            "RETURN n ORDER BY n.title ")
    List<Movie> findAllOrderByTitle();


//    @Query("MATCH " +
//            "(n2:Movie)-[:VIEWED]-(p2:Person)," +
//            "(n1:Movie)-[:VIEWED]-(p1:Person)," +
//            "(p1:Person)-[:FRIEND]-(p2:Person)," +
//            "(c2:Category)-[:MOVIE_TYPE]-(n2:Movie)," +
//            "(c1:Category)-[:MOVIE_TYPE]-(n1:Movie)"+

    @Query("MATCH " +
            "(c2:Category)-[:MOVIE_TYPE]-(n2:Movie)-[:VIEWED]-(p2:Person)-[:FRIEND]-(p1:Person)-[:VIEWED]-(n1:Movie)-[:MOVIE_TYPE]-(c2:Category)" +
            "WHERE NOT (p1)-[:VIEWED]-(n2) AND  id(p1)= {person_id} " +
            "WITH n2 as movie, count(*) as number " +
            "RETURN movie ORDER BY number DESC ")
    List<Movie> findSuggestedMovies(@Param("person_id") Long id);




    @Query("CREATE (m:Movie {title:{title},year_of_production:{year_of_production}})")
    void saveMovie(@Param("title") String title,
                    @Param("year_of_production") Long year_of_production);




}
