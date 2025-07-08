package fr.eni.demospringboot.bll;

import fr.eni.demospringboot.bo.Employe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest @AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class EmployeServiceTest {
    @Autowired
    private EmployeService employeService;

    @Test
    void save() {
        Employe employe = Employe.builder()
                .nom("CASSIN")
                .prenom("Etienne")
                .build();

        employeService.save(employe);
        assertNotNull(employe.getId());
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void deleteById() {
    }
}