package fr.eni.demospringboot.bo.heritage.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor @NoArgsConstructor
@SuperBuilder
@Entity
@DiscriminatorValue("renard")
public class RenardST extends AnimalST {
    private String robe;
}
