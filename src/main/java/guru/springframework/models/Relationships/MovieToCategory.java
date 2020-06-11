package guru.springframework.models.Relationships;


import guru.springframework.models.Category;
import guru.springframework.models.Movie;
import guru.springframework.models.Person;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "MOVIE_TYPE")
@Getter
@Setter
public class MovieToCategory {
    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Movie movie;

    @EndNode
    private Category category;

}
