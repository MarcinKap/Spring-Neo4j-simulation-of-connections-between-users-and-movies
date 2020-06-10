package guru.springframework.repositories;

import guru.springframework.models.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;




public interface PersonRepository extends Neo4jRepository<Person, Long> {



}