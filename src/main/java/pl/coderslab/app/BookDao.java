package pl.coderslab.app;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/* wersja z przed poludnia 13.04
@Repository
@Transactional
public class BookDao { @PersistenceContext
EntityManager entityManager;
    public void saveBook(Book entity) {
        entityManager.persist(entity);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }




}*/

@Component
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public List<Book> returnAllBooks() {
        Query query = entityManager.createQuery("select b from Book b");
        List<Book> allBooks = query.getResultList();
        return allBooks;
    }

}
