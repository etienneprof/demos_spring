package fr.eni.demospringboot.bo.compositePK;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity @Table(name = "etudiants")
@IdClass(EtudiantPK.class)
public class Etudiant {
    @Id
    private String email;

    @Id
    private String immatriculation;

    private String nom;
    private String prenom;
    private String numDom;
    private String numPortable;
    private String emailPerso;
}
