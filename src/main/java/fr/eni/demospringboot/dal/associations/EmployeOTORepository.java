package fr.eni.demospringboot.dal.associations;

import fr.eni.demospringboot.bo.associations.onetoone.EmployeOTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeOTORepository extends JpaRepository<EmployeOTO,Integer> {
}
