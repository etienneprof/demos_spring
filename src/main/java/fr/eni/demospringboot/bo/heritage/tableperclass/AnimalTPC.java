package fr.eni.demospringboot.bo.heritage.tableperclass;

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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// Puisqu'on est en TABLE PER CLASS
@Table(name = "animauxTPC") // uniquement sur une classe concrète
public class AnimalTPC {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String nom;
}
