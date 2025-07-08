package fr.eni.demospringboot.dal.associations;

import fr.eni.demospringboot.bo.associations.onetoone.AdresseOTO;
import fr.eni.demospringboot.bo.associations.onetoone.EmployeOTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeRepositoryTest {
    @Autowired
    EmployeOTORepository employeRepository;

    @Test
    public void save_validParameters_shouldInsert() {
        AdresseOTO adresse = AdresseOTO.builder()
                .rue("15 Rue de Paris")
                .codePostal("35000")
                .ville("Rennes")
                .build();

        EmployeOTO employe = EmployeOTO.builder()
                .nom("BAILLE")
                .prenom("Anne Lise")
                .email("abaille@campus-eni.fr")
                .immatriculation("ENI_ECOLE_12398")
                .numDom("02XXXXXXXX")
                .adresse(adresse)
                .build();

        EmployeOTO employeDB = employeRepository.save(employe);

        System.out.println(employeDB);
        EmployeOTO found = employeRepository.findById(employeDB.getId()).get();
        System.out.println(found);

        assertNotNull(employeDB);
        assertTrue(employeDB.getId() > 0);
    }
}