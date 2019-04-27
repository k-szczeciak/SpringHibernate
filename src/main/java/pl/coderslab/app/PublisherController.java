package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PublisherController {

    @Autowired
    PublisherRepository publisherRepository;

    @GetMapping("/showPublisherById/{id}")
    @ResponseBody
    public  String showPublisherId(@PathVariable String id){
        Publisher publisher = publisherRepository.findOne(Long.parseLong(id));
        //opcja 2 z wlasna metoda:
        //Publisher publisher = publisherRepository.findByName(id);

        return publisher.getName() + " - id: " + publisher.getId();
    }

    @GetMapping("/showPublisherByName/{name}")
    @ResponseBody
    public  String showPublisherName(@PathVariable String name){
        //Publisher publisher = publisherRepository.findOne(Long.parseLong(id));
        //opcja 2 z wlasna metoda:
        Publisher publisher = publisherRepository.findByName(name);

        return publisher.getName() + " - id: " + publisher.getId();
    }
}
