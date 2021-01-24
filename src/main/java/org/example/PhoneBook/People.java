package org.example.PhoneBook;


import javax.persistence.*;
import java.util.List;

@Entity
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lastName;
    private String firstName;
    private String midName;
    private String year;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "people")
    List<Phone> phoneList;

    public People() {
    }

    public People(Long id, String lastName, String firstName, String midName, String year, List<Phone> phone) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.midName = midName;
        this.year = year;
        this.phoneList = phone;
    }

    public People(Long id, String lastName, String firstName, String midName, String year) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.midName = midName;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phone) {
        this.phoneList = phone;
    }
}