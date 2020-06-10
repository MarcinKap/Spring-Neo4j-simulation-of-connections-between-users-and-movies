package guru.springframework.models;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String Surname;
    private Long age;
}
