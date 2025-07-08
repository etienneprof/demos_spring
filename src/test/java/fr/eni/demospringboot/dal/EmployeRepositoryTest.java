package fr.eni.demospringboot.dal;

import fr.eni.demospringboot.bo.Employe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
 * @DataJpaTest : pour pouvoir tester les méthodes de la BDD (autorise la connexion à la BDD)
 * @AutoConfigureTestDatabase : pour supprimer le comportement par défaut qui va chercher H2 (une BDD embarquée)
 */
@DataJpaTest @AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class EmployeRepositoryTest {

    @Autowired
    private EmployeRepository repository;

    @Test
    public void test_save() {
        Employe employe = Employe.builder()
                .nom("CASSIN")
                .prenom("Etienne")
                .build();

        repository.save(employe);
        assertNotNull(employe.getId());
        System.out.println(employe.getId());
    }

    private void jeuDeDonnees() {
        final List<Employe> lstEntites = new ArrayList<>();
        lstEntites.add(Employe
                .builder()
                .nom("BAILLE")
                .prenom("Anne-Lise")
                .email("abaille@campus-eni.fr")
                .immatriculation("ENI_ECOLE_12398")
                .numDom("02XXXXXXXX")
                .build());

        lstEntites.add(Employe
                .builder()
                .nom("DAUTAIS")
                .prenom("Servane")
                .email("sdautais@campus-eni.fr")
                .immatriculation("ENI_ECOLE_09397")
                .numPortable("06XXXXXXXX")
                .build());

        lstEntites.add(Employe
                .builder()
                .nom("DELACHESNAIS")
                .prenom("Frédéric")
                .email("fdelachesnais@campus-eni.fr")
                .immatriculation("ENI_ECOLE_15009")
                .numDom("02XXXXXXXX")
                .numPortable("06XXXXXXXX")
                .build());

        repository.saveAll(lstEntites);
    }
}