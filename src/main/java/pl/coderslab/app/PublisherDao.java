package pl.coderslab.app;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void savePublisher(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public Publisher getPublisherById(Long id) {
        Publisher publisher = entityManager.find(Publisher.class, id);
//        Hibernate.initialize(publisher.getBooks());
        return publisher;
    }

    public List<Publisher> returnAllPublishers() {
        Query query = entityManager.createQuery("select p from Publisher p");
        List<Publisher> allPublishers = query.getResultList();
        return allPublishers;
    }

}