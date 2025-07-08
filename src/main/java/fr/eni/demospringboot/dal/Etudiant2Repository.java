package fr.eni.demospringboot.dal;

import fr.eni.demospringboot.bo.compositePK2.Etudiant2;
import fr.eni.demospringboot.bo.compositePK2.EtudiantPK2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Etudiant2Repository extends JpaRepository<Etudiant2, EtudiantPK2> {
}
