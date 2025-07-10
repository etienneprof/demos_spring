package fr.eni.demospringboot.dal.associations;

import fr.eni.demospringboot.bo.associations.EtudiantENI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantENIRepository extends JpaRepository<EtudiantENI, Integer> {

    EtudiantENI findByImmatriculation(String immatriculation);
    EtudiantENI findByEmail(String email);

    List<EtudiantENI> findByPromoNom(String nom);

    @Query("SELECT e FROM EtudiantENI e WHERE e.promo.nom = 'HCDA2311B'")
    List<EtudiantENI> findByPromoHCDA2311B();

    EtudiantENI findByDonneesEmailPersonnel(String emailPersonnel);
    List<EtudiantENI> findByDonneesNomLikeOrDonneesPrenomLike(String nom, String prenom);

    @Query(value = "SELECT * FROM etudiants_eni e" +
            " LEFT JOIN civilites c ON c.clef = e.civilite_id " +
            " WHERE c.libelle = 'Madame'", nativeQuery = true)
    List<EtudiantENI> findMesdames();

}
