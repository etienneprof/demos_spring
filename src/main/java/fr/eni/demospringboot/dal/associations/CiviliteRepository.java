package fr.eni.demospringboot.dal.associations;

import fr.eni.demospringboot.bo.associations.Civilite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiviliteRepository extends JpaRepository<Civilite,String> {
}
