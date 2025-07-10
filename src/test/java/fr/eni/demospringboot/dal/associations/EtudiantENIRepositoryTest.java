package fr.eni.demospringboot.dal.associations;

import fr.eni.demospringboot.bo.associations.Civilite;
import fr.eni.demospringboot.bo.associations.DonneesPersos;
import fr.eni.demospringboot.bo.associations.EtudiantENI;
import fr.eni.demospringboot.bo.associations.Promo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EtudiantENIRepositoryTest {
    @Autowired
    private EtudiantENIRepository etudiantENIRepository;

    @Autowired
    private DonneesPersoRepository  donneesPersoRepository;

    @Autowired
    private PromoRepository promoRepository;

    @Autowired
    private CiviliteRepository civiliteRepository;

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

    @Test
    public void select_checkAll() {
        EtudiantENI etu1 = EtudiantENI.builder()
                .email("toto@gmail.com")
                .immatriculation("toto")
                .build();

        EtudiantENI etu2 = EtudiantENI.builder()
                .email("tata@gmail.com")
                .immatriculation("tata")
                .build();

        EtudiantENI etu3 = EtudiantENI.builder()
                .email("tutu@gmail.com")
                .immatriculation("tutu")
                .build();

        DonneesPersos donnees1 = DonneesPersos.builder()
                .nom("By Africa")
                .prenom("Toto")
                .numDom("0200000000")
                .numPortable("0600000000")
                .emailPersonnel("totodu44@gmail.com")
                .build();

        DonneesPersos donnees2 = DonneesPersos.builder()
                .nom("By Africa")
                .prenom("Tata")
                .numDom("0200000000")
                .numPortable("0600000000")
                .emailPersonnel("tatadu44@gmail.com")
                .build();

        DonneesPersos donnees3 = DonneesPersos.builder()
                .nom("By Africa")
                .prenom("Tutu")
                .numDom("0200000000")
                .numPortable("0600000000")
                .emailPersonnel("tutudu44@gmail.com")
                .build();

        Promo promo1 = Promo.builder()
                .nom("UnPtiNom")
                .build();

        Promo promo2 = Promo.builder()
                .nom("HCDA2311B")
                .build();

        Civilite civilite1 = Civilite.builder()
                .clef("M")
                .libelle("Monsieur")
                .build();

        Civilite civilite2 = Civilite.builder()
                .clef("Mme")
                .libelle("Madame")
                .build();

        Civilite civilite3 = Civilite.builder()
                .clef("Mx")
                .libelle("Mix")
                .build();

        etu1.setDonnees(donnees1);
        etu2.setDonnees(donnees2);
        etu3.setDonnees(donnees3);

        etu1.setPromo(promo1);
        etu2.setPromo(promo2);
        etu3.setPromo(promo1);

        etu1.setCivilite(civilite1);
        etu2.setCivilite(civilite2);
        etu3.setCivilite(civilite3);

        donneesPersoRepository.save(donnees1);
        donneesPersoRepository.save(donnees2);
        donneesPersoRepository.save(donnees3);

        promoRepository.save(promo1);
        promoRepository.save(promo2);

        civiliteRepository.save(civilite1);
        civiliteRepository.save(civilite2);
        civiliteRepository.save(civilite3);

        etudiantENIRepository.save(etu1);
        etudiantENIRepository.save(etu2);
        etudiantENIRepository.save(etu3);

        System.out.println(etudiantENIRepository.findByImmatriculation("tutu"));
        System.out.println(etudiantENIRepository.findByEmail("tata@gmail.com"));

        System.out.println(etudiantENIRepository.findByPromoNom("UnPtiNom"));
        System.out.println(etudiantENIRepository.findByPromoHCDA2311B());

        System.out.println(etudiantENIRepository.findByDonneesNomLikeOrDonneesPrenomLike("%a%", "%a%"));

        System.out.println(etudiantENIRepository.findMesdames());

    }

}