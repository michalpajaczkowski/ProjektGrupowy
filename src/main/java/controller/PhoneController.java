package controller;

import hibernate.Employees;
import hibernate.HibernateDao;
import hibernate.Phones;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PhoneController {

    private HibernateDao phoneDao;
    private List<Employees> list = new ArrayList<>();

    public PhoneController() {
        phoneDao = new HibernateDao();
    }

    @RequestMapping("/phoneform")
    public ModelAndView showform(Model model) {
        list.clear();
        list = phoneDao.getEmployees();
        model.addAttribute("list", list);
        return new ModelAndView("phoneform", "command", new Phones());
    }

    @RequestMapping(value = "/savePhone", method = RequestMethod.POST)
    public ModelAndView savePhone(@ModelAttribute("phones") Phones phones) {

        phones.setEmployees(getEmployeesById(phones.employees.getId()));
        phoneDao.saveHibernateEntity(phones);

        return new ModelAndView("redirect:");
    }

    private Employees getEmployeesById(@RequestParam int id) {
        return list.stream().filter(f -> f.getId() == id).findFirst().get();
    }
}
