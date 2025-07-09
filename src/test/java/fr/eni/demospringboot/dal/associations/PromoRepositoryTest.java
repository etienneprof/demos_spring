package fr.eni.demospringboot.dal.associations;

import fr.eni.demospringboot.bo.associations.DonneesPersos;
import fr.eni.demospringboot.bo.associations.EtudiantENI;
import fr.eni.demospringboot.bo.associations.Promo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PromoRepositoryTest {
    @Autowired
    PromoRepository repository;

    @Autowired
    EtudiantENIRepository etudiantRepository;


    @Test
    public void test_save() {

        final Promo promo = Promo
                .builder()
                .nom("EDWM_TEST")
                .build();

// Association OneToMany
        promo.setEtudiants(jeuDeDonnees());

// Appel du comportement
        final Promo promoDB = repository.save(promo);

        // Vérification de l'identifiant
        assertThat(promoDB.getId()).isGreaterThan(0);

        // Vérification de la cascade de l'association
        assertThat(promoDB.getEtudiants()).isNotNull();
        assertThat(promoDB.getEtudiants()).isNotEmpty();
        assertThat(promoDB.getEtudiants().size()).isEqualTo(3);
        System.out.println(promoDB.toString());
    }



    @Test
    public void test_delete() {
        final Promo promo = Promo
                .builder()
                .nom("EDWM_TEST")
                .build();

        // Association OneToMany
        promo.setEtudiants(jeuDeDonnees());


// Contexte de la DB
        Promo promoDB = repository.save(promo);

        List<EtudiantENI> etudiantsDB = promoDB.getEtudiants();
        List<String> listeIdEtudiantENIDB = etudiantsDB
                .stream()
                .map(EtudiantENI::getImmatriculation)
                .toList();

// Appel du comportement
        repository.delete(promoDB);

// Vérification que l'entité a été supprimée
        List<EtudiantENI> etudiants = etudiantRepository.findAll();
        assertTrue(listeIdEtudiantENIDB.isEmpty());
    }


    private List<EtudiantENI> jeuDeDonnees() {

        final List<EtudiantENI> etudiants = new ArrayList<>();

        String immatriculation = "ENI_CAMPUS_20231187";



        for (int i = 1; i < 4; i++) {

            final DonneesPersos donneesPersos = DonneesPersos.builder()
                    .nom("Nom"+i)
                    .prenom("Prenom"+i)
                    .numDom("02XXXXXXXX")
                    .numPortable("07XXXXXXXX")
                    .emailPersonnel("Nom"+i+".Prenom"+i+"@perso.fr")
                    .build();

            final EtudiantENI etudiant = EtudiantENI
                    .builder()
                    .immatriculation(immatriculation+i)
                    .email("pnom"+i+"@campus-eni.fr")
                    .build();

            etudiant.setDonnees(donneesPersos);

            donneesPersos.setEtudiantENI(etudiant);
            etudiants.add(etudiant);
        }

        return etudiants;

    }
}