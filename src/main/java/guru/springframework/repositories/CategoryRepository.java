package guru.springframework.repositories;

import guru.springframework.models.Category;
import guru.springframework.models.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CategoryRepository extends Neo4jRepository<Category, Long> {
}
