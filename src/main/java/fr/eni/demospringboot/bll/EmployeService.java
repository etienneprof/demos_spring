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
        employeRepository.save(employe); // insert & update
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
