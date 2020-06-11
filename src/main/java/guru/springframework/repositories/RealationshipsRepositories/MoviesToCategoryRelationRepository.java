package guru.springframework.repositories.RealationshipsRepositories;

import guru.springframework.models.Relationships.MovieToCategory;
import guru.springframework.models.Relationships.PersonToPerson;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MoviesToCategoryRelationRepository extends Neo4jRepository<MovieToCategory, Long> {
}
