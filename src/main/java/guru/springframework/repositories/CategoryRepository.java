package guru.springframework.repositories;

import guru.springframework.models.Category;
import guru.springframework.models.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends Neo4jRepository<Category, Long> {


    @Query ("MATCH (n:Category)-[:MOVIE_TYPE]-(m:Movie) " +
            "WHERE id(m)= {movie_id}" +
            "RETURN n  ")
    List<Category> findByMovieId(@Param("movie_id") Long id);



    @Query("MATCH (n:Category)" +
            "RETURN n ORDER BY n.name ")
    List<Category> findAllOrOrderByName();


    @Query("CREATE (m:Category {name:{name}})")
    void saveCategory(@Param("name") String name);


}
