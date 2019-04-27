package pl.coderslab.app;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    //tu wszystkie nowe motody nie ze stringa
    Publisher findByName(String publisherName);
}
