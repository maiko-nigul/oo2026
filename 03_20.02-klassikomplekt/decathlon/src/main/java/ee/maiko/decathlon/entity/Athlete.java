package ee.maiko.decathlon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;

import java.util.Set;

@Entity
@Getter @Setter
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL)
    private Set<Result> results = new HashSet<>();
}
