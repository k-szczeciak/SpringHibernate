package pl.coderslab.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByPublisher(Publisher publisher);

    @Query("select b from Book b where b.name like %?1")
    List<Book> findByTitleNow(String name);


}
