package fr.eni.demospringboot.bll.old;

import fr.eni.demospringboot.bo.Employe;
import fr.eni.demospringboot.dal.old.EmployeDAL;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeBLLSpringImpl implements EmployeBLL{
    @Autowired
    private EmployeDAL empDAL;

    @Transactional
    public void manipulerEmploye() {
        Employe emp = new Employe();
        emp.setNom("CASSIN");
        emp.setPrenom("Etienne");

        Employe emp2 = new Employe(
                null,
                "CASSIN",
                "Etienne",
                null,
                null,
                null,
                null);

        Employe emp3 = Employe.builder()
                .nom("CASSIN")
                .prenom("Etienne")
                .build();

    }
}
