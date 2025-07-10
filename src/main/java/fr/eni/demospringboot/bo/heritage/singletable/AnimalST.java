package fr.eni.demospringboot.bo.heritage.singletable;

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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// Puisqu'on est en SINGLE TABLE
@Table(name = "animauxST")
@DiscriminatorColumn(name = "espece")
@DiscriminatorValue("animal") // utile uniquement si Animal est concret
public class AnimalST {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
}
