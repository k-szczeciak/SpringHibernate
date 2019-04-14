package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Transactional
public class PersonController {
/*
    @Autowired
    private PersonRepository personRepository;*/

@Autowired
    private PersonDao personDao;

    @GetMapping("/personForm")
    public String showPersonForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "person";
    }

//    @PostMapping("/personForm")
//    @ResponseBody
//    public String getFromForm(@RequestParam String firstName, @RequestParam String lastName) {
//        return firstName + " " + lastName;
//    }

    @PostMapping("/personForm")
    @ResponseBody
    public String getFromForm(@ModelAttribute Person person) {
        personDao.savePerson(person);
        return person.getFirstName() + " " + person.getLastName();
    }
}
