package fr.eni.demospringboot.bo.heritage.joined;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity @Table(name = "paresseuxJ")
@DiscriminatorValue("paresseux")
public class ParesseuxJ extends AnimalJ {
    private boolean endormi;
}
