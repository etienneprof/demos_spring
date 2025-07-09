package fr.eni.demospringboot.bo.associations;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@EqualsAndHashCode(exclude = "etudiantENI")
@ToString(exclude = "etudiantENI")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "donnees_persos")
public class DonneesPersos {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private String numDom;
    private String numPortable;
    private String emailPersonnel;

    @OneToOne(mappedBy = "donnees")
    private EtudiantENI etudiantENI;
}
