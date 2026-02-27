package ee.maiko.rentalstore.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private FilmType type; // Enum - kindlaksm22ratud v22rtuste hulgast saan valida
    private int days; // mitu päeva on renditud. 0 - available

    @ManyToOne
    private Rental rental;

}
