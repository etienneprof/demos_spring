package fr.eni.demospringboot.dal.associations;

import fr.eni.demospringboot.bo.associations.DonneesPersos;
import fr.eni.demospringboot.bo.associations.EtudiantENI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EtudiantENIRepositoryTest {
    @Autowired
    private EtudiantENIRepository etudiantENIRepository;

    @Test
    public void save_validParameters_shouldInsert() {
        EtudiantENI etu = EtudiantENI.builder()
                .email("toto@gmail.com")
                .immatriculation("toto")
                .build();

        DonneesPersos donnees = DonneesPersos.builder()
                .nom("By Africa")
                .prenom("Toto")
                .numDom("0200000000")
                .numPortable("0600000000")
                .emailPersonnel("totodu44@gmail.com")
                .build();

        etu.setDonnees(donnees);
        donnees.setEtudiantENI(etu);

        EtudiantENI saved = etudiantENIRepository.save(etu);

        System.out.println(saved);
    }
}