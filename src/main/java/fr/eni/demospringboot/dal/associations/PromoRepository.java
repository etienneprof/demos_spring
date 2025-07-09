package fr.eni.demospringboot.dal.associations;

import fr.eni.demospringboot.bo.associations.Promo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoRepository extends JpaRepository<Promo, Integer> {
}
