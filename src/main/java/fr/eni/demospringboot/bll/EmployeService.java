package fr.eni.demospringboot.bll;

import fr.eni.demospringboot.bo.Employe;
import fr.eni.demospringboot.dal.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {
    private EmployeRepository employeRepository;

    @Autowired
    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public void save(Employe employe){
        if (employe == null) throw new IllegalArgumentException("employe is null");

        checkEmptyString(employe.getImmatriculation(), "Cannot insert empty registration");
        checkEmptyString(employe.getNom(), "Cannot insert empty last name");
        checkEmptyString(employe.getPrenom(), "Cannot insert empty first name");
        checkEmptyString(employe.getEmail(), "Cannot insert empty email");

        employeRepository.save(employe); // insert & update
    }

    private void checkEmptyString(String stringToTest, String message) {
        if (stringToTest == null || stringToTest.isEmpty())
            throw new IllegalArgumentException(message);
    }

    public List<Employe> findAll(){
        return employeRepository.findAll(); // select * from employees
    }

    public Employe findById(int id){
        return employeRepository.findById(id).orElseThrow();
    }

    public void deleteById(int id){
        employeRepository.deleteById(id);
    }
}
