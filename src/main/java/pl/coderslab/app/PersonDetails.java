package pl.coderslab.app;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "persons_details")
public class PersonDetails {

    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String streetNumber;
    private String street;
    private String city;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "person_id")
    private Person person;

    public PersonDetails() {
    }

    public PersonDetails(String firstName, String lastName, String streetNumber, String street, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetNumber = streetNumber;
        this.street = street;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
