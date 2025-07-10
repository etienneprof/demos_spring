package fr.eni.demospringboot.bo.heritage.joined;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor @NoArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
// Puisqu'on est en JOINED
@Table(name = "animauxJ")
@DiscriminatorColumn(name = "espece")
@DiscriminatorValue("animal") // utile uniquement si Animal est concret
public class AnimalJ {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
}
