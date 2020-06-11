package guru.springframework.repositories;

import guru.springframework.models.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;




public interface PersonRepository extends Neo4jRepository<Person, Long> {


//    @Query (MATCH())
//    void addRelationshipBetweenPersons(Long personId, Long person2Id);


    Person getPersonByNameAndSurnameAndAge(String name, String surname, Long age);



}