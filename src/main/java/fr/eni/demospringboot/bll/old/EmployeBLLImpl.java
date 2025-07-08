package fr.eni.demospringboot.bll.old;

import fr.eni.demospringboot.dal.old.DALFactory;
import fr.eni.demospringboot.dal.old.EmployeDAL;

public class EmployeBLLImpl {

    private EmployeDAL empDAL;

    public EmployeBLLImpl() {
        empDAL = DALFactory.getEmployeDAL();
    }
}
