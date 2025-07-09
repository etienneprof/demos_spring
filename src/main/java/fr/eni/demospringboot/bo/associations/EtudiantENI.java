package fr.eni.demospringboot.bo.associations;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity @Table(name = "etudiants_eni")
public class EtudiantENI {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String immatriculation;
    private String email;

    @OneToOne
    @JoinColumn(name = "donnees_persos_id")
    private DonneesPersos donnees;
}
