package fr.eni.demospringboot.dal.associations;

import fr.eni.demospringboot.bo.associations.DonneesPersos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonneesPersoRepository extends JpaRepository<DonneesPersos, Integer> {
}
