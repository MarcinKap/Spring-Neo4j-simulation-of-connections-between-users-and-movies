package guru.springframework.models;


import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.UNDIRECTED;

@NodeEntity
@Getter
@Setter
public class Category {

    private Long id;

    private String name;

    @Relationship(type = "MOVIE_TYPE", direction = UNDIRECTED)
    private List<Movie> movies = new ArrayList<>();



}
