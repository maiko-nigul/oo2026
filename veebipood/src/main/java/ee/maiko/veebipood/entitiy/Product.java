package ee.maiko.veebipood.entitiy;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private boolean active;
    private int stock;

    // @ManyToMany -- private List<Ingiridients> ingridients
    // @OneToMany -- private List<Ingiridients> ingridients
    // @ManyToOne -- tooted jagavad seda kategooriat mitu producti - 1category
    // @OneToOne -- tooted ei jaga seda kategooriat 1product - 1category

    @ManyToOne
    private Category category; // automaatselt võõrvõtmega (@Id v2ljaga) siia tabelisse
    //Panene andmeid andmebaasi, aga ei määra väärtust
    // double -> 0
    // boolean -> false
    // int  -> 0

    // Double -> null
    // Boolean ->   null
    // Integer ->   null
}
