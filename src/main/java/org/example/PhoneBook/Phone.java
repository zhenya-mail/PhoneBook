package org.example.PhoneBook;

import javax.persistence.*;
import org.example.PhoneBook.People;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    private People people;
    private String phone00;
    private String phone01;
    private String phone02;
    private String phone03;
    private String phone04;


    public Phone() {
    }

    public Phone(String phone0, String phone1, String phone2, String phone3, String phone4) {
        phone00 = phone0;
        phone01 = phone1;
        phone02 = phone2;
        phone03 = phone3;
        phone04 = phone4;



    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public String getPhone00() {
        return phone00;
    }

    public void setPhone00(String phone00) {
        this.phone00 = phone00;
    }

    public String getPhone01() {
        return phone01;
    }

    public void setPhone01(String phone01) {
        this.phone01 = phone01;
    }

    public String getPhone02() {
        return phone02;
    }

    public void setPhone02(String phone02) {
        this.phone02 = phone02;
    }

    public String getPhone03() {
        return phone03;
    }

    public void setPhone03(String phone03) {
        this.phone03 = phone03;
    }

    public String getPhone04() {
        return phone04;
    }

    public void setPhone04(String phone04) {
        this.phone04 = phone04;
    }

}