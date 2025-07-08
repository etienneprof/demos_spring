package fr.eni.demospringboot.dal;

import fr.eni.demospringboot.bo.compositePK.Etudiant;
import fr.eni.demospringboot.bo.compositePK.EtudiantPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, EtudiantPK> {
}
