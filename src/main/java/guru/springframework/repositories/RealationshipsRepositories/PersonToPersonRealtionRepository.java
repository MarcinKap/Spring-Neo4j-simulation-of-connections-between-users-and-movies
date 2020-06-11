package guru.springframework.repositories.RealationshipsRepositories;

import guru.springframework.models.Person;
import guru.springframework.models.Relationships.PersonToPerson;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PersonToPersonRealtionRepository extends Neo4jRepository<PersonToPerson, Long> {
}
