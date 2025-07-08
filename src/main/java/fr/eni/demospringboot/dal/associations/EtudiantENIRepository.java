package fr.eni.demospringboot.dal.associations;

import fr.eni.demospringboot.bo.associations.onetoone.EtudiantENI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantENIRepository extends JpaRepository<EtudiantENI, Integer> {
}
