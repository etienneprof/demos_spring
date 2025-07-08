package fr.eni.demospringboot.bll;

import fr.eni.demospringboot.bo.Employe;
import fr.eni.demospringboot.dal.EmployeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeServiceTest {

    private EmployeService employeService;

    @Mock
    private EmployeRepository employeRepository;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        employeService = new EmployeService(employeRepository);
    }

    @Test
    void test_save_allParamsValid() {
        int id = 1;
        Employe employe = Employe
                .builder()
                .id(id)
                .nom("BAILLE")
                .prenom("Anne-Lise")
                .email("abaille@campus-eni.fr")
                .immatriculation("ENI_Ecole_012892")
                .numDom("0299XXXXXX")
                .numPortable("0699XXXXXX")
                .build();

        // Définir le comportement du Repository mocké
        when(employeRepository.findById(id)).thenReturn(Optional.of(employe));

        // Comportemnet à valider
        employeService.save(employe);

        // Vérification de l'ajout dans la liste des employés
        Optional<Employe> op = employeRepository.findById(id);
        assertNotNull(op);
        assertThat(op.isPresent()).isTrue();

        final Employe employeDB = op.get();
        assertNotNull(employeDB);
        assertThat(employe.getImmatriculation()).isEqualTo(employeDB.getImmatriculation());
        assertThat(employe.getEmail()).isEqualTo(employeDB.getEmail());
        assertThat(employe.getNom()).isEqualTo(employeDB.getNom());
        assertThat(employe.getPrenom()).isEqualTo(employeDB.getPrenom());
        assertThat(employe.getNumDom()).isEqualTo(employeDB.getNumDom());
        assertThat(employe.getNumPortable()).isEqualTo(employeDB.getNumPortable());
    }

    @Test
    void test_save_failure() {
        int id = 1;
        Employe employe = Employe
                .builder()
                .id(id)
                .nom("")
                .prenom("")
                .email("")
                .immatriculation("ENI_Ecole_012892")
                .numDom("0299XXXXXX")
                .numPortable("0699XXXXXX")
                .build();

        // Comportemnet à valider
        var e = assertThrows(IllegalArgumentException.class, () -> employeService.save(employe));
        assertEquals("Cannot insert empty last name", e.getMessage());
    }
}