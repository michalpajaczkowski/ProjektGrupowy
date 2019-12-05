package hibernate;

import java.util.HashSet;
import java.util.Set;

public class SupplyDatabase{
	
	public SupplyDatabase(){
		supplyDatabase();
	}
	
	private void supplyDatabase(){
		HibernateDao hibernateDao = new HibernateDao();

		Employees employees = new Employees();
		employees.setFirstName("Jan");
		employees.setLastName("Nowak");
		employees.setAge(19);
		employees.setBenefit(1);
		employees.setCity("Warszawa");
		employees.setSalary(9000);
		employees.setAddress("Złota");

		hibernateDao.saveHibernateEntity(employees);

		Cars cars = new Cars();
		cars.setEmployees(employees);
		cars.setModel("126p");
		cars.setName("Fiat");

		hibernateDao.saveHibernateEntity(cars);

		Set<Cars> carsSet = new HashSet<>();
		carsSet.add(cars);

		employees.setCars(carsSet);

		Printer printer = new Printer();
		printer.setEmployees(employees);
		printer.setProducer("HP");
		printer.setModel("100");
		printer.setEmployees(employees);

		Set<Printer> printerSet = new HashSet<>();
		printerSet.add(printer);

		employees.setPrinters(printerSet);

		hibernateDao.updateHibernateEntity(employees);
	}
}