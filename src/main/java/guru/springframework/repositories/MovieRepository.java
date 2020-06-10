package guru.springframework.repositories;

import guru.springframework.models.Movie;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {



}
