package guru.springframework.models;


import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Getter
@Setter
public class Movie {

    private Long id;

    private String title;




}
