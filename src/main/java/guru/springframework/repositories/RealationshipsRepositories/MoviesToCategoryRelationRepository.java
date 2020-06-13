package guru.springframework.repositories.RealationshipsRepositories;

import guru.springframework.models.Relationships.MovieToCategory;
import guru.springframework.models.Relationships.PersonToPerson;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface MoviesToCategoryRelationRepository extends Neo4jRepository<MovieToCategory, Long> {

    @Query("MATCH (n), (m) " +
            "WHERE id(n)={id_n} AND id(m)={id_m} " +
            "CREATE (n)-[:MOVIE_TYPE{}]->(m)")
    void saveRelationship(@Param("id_n") Long movie, @Param("id_m") Long category);


}
