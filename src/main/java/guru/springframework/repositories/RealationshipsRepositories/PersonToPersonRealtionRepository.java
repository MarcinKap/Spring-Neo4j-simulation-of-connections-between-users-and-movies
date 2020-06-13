package guru.springframework.repositories.RealationshipsRepositories;

import guru.springframework.models.Person;
import guru.springframework.models.Relationships.PersonToPerson;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface PersonToPersonRealtionRepository extends Neo4jRepository<PersonToPerson, Long> {



    @Query("MATCH (n), (m) " +
            "WHERE id(n)={id_n} AND id(m)={id_m} " +
            "CREATE (n)-[:FRIEND{}]->(m)")
    void saveFriendship(@Param("id_n") Long person_1, @Param("id_m") Long person_2);






}
