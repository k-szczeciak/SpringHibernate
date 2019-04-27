package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;



/* z przed poludniem
@Controller
public class BookController {
    @Autowired
    private BookDao bookDao;
    @RequestMapping(path = "/hello", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String hello(){
        Book book = new Book(); book.setTitle("Thinking in Java"); book.setAuthor("Bruce Eckel");
        bookDao.saveBook(book);
        return "Id dodanej książki to:" + book.getId();
    }


    @RequestMapping(path = "/addbook/{author}/{title}")
    @ResponseBody
    private String requestParamsUri(@PathVariable("author") String author,
                                    @PathVariable("title") String title) {

        Book book = new Book(title, author);

        bookDao.saveBook(book);
        return "zapisana " + bookDao.findById(book.getId());

    }

}*/

@Controller
public class BookController {

    @Autowired
    private PublisherDao publisherDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    BookRepository bookRepository;

    @ModelAttribute("allPublishers")
    public List<Publisher> getAllPublisher() {
        return publisherDao.returnAllPublishers();
    }

    @ModelAttribute("allBooks")
    public List<Book> getAllBooks() {
        return bookDao.returnAllBooks();
    }

    @GetMapping("/allBooks")
    public String showAllBooks() {
        return "allBooks";
    }

    @GetMapping("/addBook")
    public String addBookForm(Model model) {
        Book book = new Book();
        model.addAttribute(book);
        return "book";
    }
    @GetMapping("/findByPublisher/{idPublisher}")
    @ResponseBody
    public String findBooksByPublisherID(@PathVariable String idPublisher){
        Publisher publisher = publisherRepository.findOne(Long.parseLong(idPublisher));
        List<Book> books = bookRepository.findByPublisher(publisher);
        return Arrays.toString(books.toArray());
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute Book book) {
//        Publisher publisher = publisherDao.getPublisherById(book.getPublisher().getId());
//        book.setPublisher(publisher);
        bookDao.saveBook(book);
        return "redirect:/allBooks";
    }




}
