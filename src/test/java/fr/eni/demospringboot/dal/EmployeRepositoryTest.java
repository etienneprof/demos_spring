package fr.eni.demospringboot.dal;

import fr.eni.demospringboot.bo.Employe;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
 * @DataJpaTest : pour pouvoir tester les méthodes de la BDD (autorise la connexion à la BDD)
 * @AutoConfigureTestDatabase : pour supprimer le comportement par défaut qui va chercher H2 (une BDD embarquée)
 * @TestMethodOrder : pour que les tests s'exécutent en respectant l'ordre indiqué par les @Order
 */
@DataJpaTest @AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeRepositoryTest {

    @Autowired
    private EmployeRepository repository;

    @Test
    @Order(3)
    public void test_save() {
        Employe employe = Employe.builder()
                .nom("CASSIN")
                .prenom("Etienne")
                .build();

        repository.save(employe);
        assertNotNull(employe.getId());
        System.out.println(employe.getId());
    }

    @Test
    @Order(1)
    public void test_findById() {
        jeuDeDonnees();
        Employe emp = repository.findById(1).orElseThrow();
        assertEquals("BAILLE",emp.getNom());
        assertEquals("Anne-Lise",emp.getPrenom());
        assertEquals("abaille@campus-eni.fr",emp.getEmail());
        assertEquals("ENI_ECOLE_12398",emp.getImmatriculation());
        assertEquals("02XXXXXXXX",emp.getNumDom());
    }

    @Test
    @Order(2)
    public void test_findAll() {
        jeuDeDonnees();
        List<Employe> employees = repository.findAll();
        assertNotNull(employees);
        assertEquals(3,employees.size());
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