package ee.maiko.decathlon.entity;

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
    private Double value;
    private Integer points;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;
}