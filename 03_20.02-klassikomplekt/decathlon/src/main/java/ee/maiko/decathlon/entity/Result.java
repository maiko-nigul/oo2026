package ee.maiko.decathlon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String discipline;
    private Integer points;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    @JsonIgnore
    private Athlete athlete;
}