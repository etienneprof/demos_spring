package fr.eni.demospringboot.dal;

import fr.eni.demospringboot.bo.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer> { }
