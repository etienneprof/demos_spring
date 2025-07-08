package fr.eni.demospringboot.bo;

import jakarta.persistence.*;
import lombok.*;

// @Data
@NoArgsConstructor @AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= {"nom", "prenom"})
@ToString
@Builder
@Entity @Table(name="employees")
public class Employe {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "LAST_NAME", length = 90)
    private String nom;

    @Column(name = "FIRST_NAME", length = 150)
    private String prenom;

    @Column(name = "EMAIL", length = 255)
    private String email;

    @Column(name = "REGISTRATION", length = 100)
    private String immatriculation;

    @Column(name = "HOME_PHONE_NUMBER", length = 12)
    private String numDom;

    @Column(name = "CELL_NUMBER", length = 12)
    private String numPortable;
}
