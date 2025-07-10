package fr.eni.demospringboot.dal.associations;

import fr.eni.demospringboot.bo.associations.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant,Integer> {
}
