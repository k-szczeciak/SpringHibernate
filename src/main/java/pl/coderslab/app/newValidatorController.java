package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.*;

@Controller
@Transactional
public class newValidatorController {

    @Autowired
    Validator validator;

    @GetMapping("/testOfBookValidator")
    @ResponseBody
    public  Map<String, String> validateBook(Model model){
        Book book = new Book();

        book.setName("the");
        book.setRating(8);
        book.setSurname("tt");
        book.setDescription("bafrzon ,jdfksdhnkchksehfksgbjskfkbsghbfjgxjfhsdjksdhfjkdrllll");
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        List<String> violationsList = new ArrayList<>();
        Map<String, String> violatonMap = new HashMap<>();

        //model.addAttribute("violations", violations);

        if (!violations.isEmpty()){
            for (ConstraintViolation<Book> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + constraintViolation.getMessage());
                violationsList.add(constraintViolation.getMessage());
                violatonMap.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
            }
            model.addAttribute("violationsList", violationsList);
            //return "testOfBookValidator";
            return violatonMap;
            }else{
                // save object }
                return null;
            }

    }

}
