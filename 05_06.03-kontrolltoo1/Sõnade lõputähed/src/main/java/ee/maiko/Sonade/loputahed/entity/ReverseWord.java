package ee.maiko.Sonade.loputahed.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class ReverseWord {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private final String reversedContent;

}
