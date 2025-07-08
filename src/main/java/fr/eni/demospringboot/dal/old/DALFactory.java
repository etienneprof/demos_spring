package fr.eni.demospringboot.dal.old;

/*
    Mise en place des Design Pattern Singleton et Factory
 */
public abstract class DALFactory {
    private static EmployeDAL employeDAL;

    public static EmployeDAL getEmployeDAL() {
        if (employeDAL == null) {
            employeDAL = new EmployeDALImpl();
        }
        return  employeDAL;
    }
}
