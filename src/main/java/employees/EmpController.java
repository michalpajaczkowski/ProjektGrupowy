package employees;

import hibernate.HibernateDao;
import hibernate.Employees;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmpController {
    private List<Employees> list;

    public EmpController() {
        HibernateDao employeeDao = new HibernateDao();
        list = employeeDao.getEmployees();
    }

    @RequestMapping("/empform")
    public ModelAndView showform(){
        return new ModelAndView("empform","command", new Employees());
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("employees") Employees employee){
        if(employee.getId() < 0) {
            System.out.println("New emp");
            employee.setId(list.size()+1);
            list.add(employee);
        } else {
            //update
            System.out.println("Update employee nr: "+employee.getId());

            Employees empTemp = getEmployeesById(employee.getId());
//            employee.setName(empTemp.getName());
//            employee.setSalary(empTemp.getSalary());
//            employee.setDesignation(empTemp.getDesignation());
        }
        System.out.println(employee.getFirstName()+" "+employee.getSalary()+" "+employee.getLastName());
        return new ModelAndView("redirect:/viewemp");
    }

    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public ModelAndView delete(@RequestParam String id){
        list.remove(getEmployeesById(Integer.parseInt(id)));
        return new ModelAndView("redirect:/viewemp");
    }

    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public ModelAndView edit(@RequestParam String id){
        Employees employees = getEmployeesById(Integer.parseInt(id));
        return new ModelAndView("empform","command", employees);
    }

    @RequestMapping(value="/test", method=RequestMethod.POST)
    public ModelAndView test(){
        System.out.println("Test");
        return new ModelAndView("redirect:/viewemp");
    }

    @RequestMapping("/viewemp")
    public ModelAndView viewemp(){
        return new ModelAndView("viewemp","list", list);
    }

    private Employees getEmployeesById(@RequestParam int id) {
        return list.stream().filter(f -> f.getId() == id).findFirst().get();
    }
}