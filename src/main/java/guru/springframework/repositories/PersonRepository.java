package guru.springframework.repositories;

import guru.springframework.models.Category;
import guru.springframework.models.Movie;
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


    @Query ("MATCH (n:Person), (m:Person)-[:FRIEND]-(p) "+
            "WHERE NOT id(n)= {person_id} AND NOT n=m AND id(p)={person_id}" +
            "RETURN n  ")
    List<Person> findByPeopleForFriendship(@Param("person_id") Long id);


    @Query("MATCH (n:Person)" +
            "RETURN n ORDER BY n.name ")
    List<Person> findAllOrOrderByName();


    @Query("CREATE (p:Person {name:{name}, surname:{surname},age:{age} })")
    void savePerson(@Param("name") String name,
                    @Param("surname") String surname,
                    @Param("age") Long age);


    @Query ("MATCH (n:Person)-[:FRIEND]-(m:Person)-[:FRIEND]-(p) "+
            "WHERE NOT id(n)= {person_id} AND id(p)={person_id} AND NOT (n:Person)-[:FRIEND]-(p:Person)" +
            "WITH n as newFriend, COUNT(*) as number " +
            "RETURN newFriend ORDER BY number DESC LIMIT 4  ")
    List<Person> findProposedPeopleForFriendship(@Param("person_id") Long id);





    @Query("CALL apoc.import.json({path})")
    void LoadCSVFile(@Param("path") String path);



    @Query("match (b), (a) -[r] -> () delete a, r, b")
    void deleteAllRelationshipsAndNodes();

//


}