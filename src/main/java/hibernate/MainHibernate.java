package hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainHibernate {
    public static void main(String[] args) {
        HibernateDao employeeDao = new HibernateDao();
        Employees employee = new Employees("Test", "Test", "Test", "Test", 1000, 18 , new Date(), 1);
        employeeDao.saveHibernateEntity(employee);
        List<Employees> employeesList = employeeDao.getEmployees();

        Employees employeeToUpdate = employeesList.get(0);
        employeeToUpdate.setSalary(1111);
        employeeDao.updateHibernateEntity(employeeToUpdate);

        employeesList.forEach(System.out::println);

        HibernateDao phoneDao = new HibernateDao();
        Phones phones = new Phones("Sony", "Xperia 10", employee);
        phoneDao.saveHibernateEntity(phones);
        Set<Phones> phonesList = new HashSet<>();
        phonesList.add(phones);
        employee.setPhones(phonesList);
        employeeDao.updateHibernateEntity(employee);

        HibernateDao carsDao = new HibernateDao();
        Cars cars = new Cars("Audi","Q7",employee );
        carsDao.saveHibernateEntity(cars);
        Set<Cars> carsList = new HashSet<>();
        carsList.add(cars);
        employee.setCars(carsList);
        employeeDao.updateHibernateEntity(employee);

        HibernateDao printerDao = new HibernateDao();
        Printer printer = new Printer("Xerox","sf99",employee);
        printerDao.saveHibernateEntity(printer);
        Set<Printer> printerList = new HashSet<>();
        printerList.add(printer);
        employee.setPrinters(printerList);
        employeeDao.updateHibernateEntity(employee);



    }
}
