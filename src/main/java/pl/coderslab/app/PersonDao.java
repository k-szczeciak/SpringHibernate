package pl.coderslab.app;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


    @Repository
    @Transactional
    public class PersonDao {
        @PersistenceContext
        EntityManager entityManager;

        public void savePerson(Person entity) {
            entityManager.persist(entity);
        }
    }


