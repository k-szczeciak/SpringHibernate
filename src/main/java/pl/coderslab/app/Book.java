package pl.coderslab.app;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
/*

//wersja z polowy dnia 13.04

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "myTitle",
            length=100,
            nullable = false)
    private String title;
    private String author;
    @Column(scale = 2, precision = 4)
    private BigDecimal rating;
    private String publisher;
    @Column(columnDefinition="TEXT")
    private String description;


    public Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}*/

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @Column(name = "book_name")
//    @NotNull
//    @Size(groups = {TestValidationGroup.class}, min = 3, max = 8)

    @NotNull
    @Size(min = 5)
    @StartWith("N")
    private String name;

//    @Temporal(TemporalType.DATE)

    //    @CheckDate(year = 2005)
    private Integer publishDate;

    //    @NotNull(message = "Surname - nie może być pusta")
//    @Size(groups = {TestValidationGroup.class}, min = 5, max = 15, message = "Surname - zła wielkość pola")

    @NotNull
    @Size(min = 5)
    private String surname;

    //    @Column(length = 50)
    @Size(min = 2, max = 20)
    private String description;

    //    @Column(name = "book_rating")
    @NotNull
    @Min(1)
    @Max(5)
    private int rating;

    @ManyToOne
    private Publisher publisher;

    public Book() {
    }

    public Integer getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Integer publishDate) {
        this.publishDate = publishDate;
    }

    //    public Date getPublishDate() {
//        return publishDate;
//    }
//
//    public void setPublishDate(Date publishDate) {
//        this.publishDate = publishDate;
//    }

    public Book(String name) {
        this.name = name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
        publisher.getBooks().add(this);
    }

    public void removePublisher(Publisher publisher) {
        this.publisher.getBooks().remove(this);
        this.publisher = null;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                //", publisher=" + publisher +
                '}';
    }
}
