package fr.eni.demospringboot.bo.associations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
@Entity @Table(name = "civilites")
public class Civilite {
    @Id
    private String clef;

    @Column(name = "libelle", unique = true, length = 50)
    private String libelle;
}
