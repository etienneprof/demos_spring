package fr.eni.demospringboot.bo.compositePK2;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity @Table(name = "etudiants")
public class Etudiant2 {
    @EmbeddedId
    private EtudiantPK2 id;

    private String nom;
    private String prenom;
    private String numDom;
    private String numPortable;
    private String emailPerso;
}
