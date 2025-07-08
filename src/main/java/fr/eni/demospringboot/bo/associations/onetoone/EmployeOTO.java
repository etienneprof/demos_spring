package fr.eni.demospringboot.bo.associations.onetoone;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity @Table(name="employes")
public class EmployeOTO {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String immatriculation;
    private String numDom;
    private String numPortable;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
    @JoinColumn(name = "adresse_id")
    private AdresseOTO adresse;
}
