package org.example.PhoneBook;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany (cascade = CascadeType.ALL)
    List<Phone> phoneList = new ArrayList<>();

    private String lastName;
    private String firstName;
    private String midName;
    private String year;
    private String phone0;
    private String phone1;
    private String phone2;
    private String phone3;
    private String phone4;

    public People() {
    }

    public People(Integer id, String lastName, String firstName, String midName, String year, String phone0, String phone1, String phone2, String phone3, String phone4) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.midName = midName;
        this.year = year;
        this.phone0 = phone0;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.phone4 = phone4;

    }

    public People(Phone phone, String lastName, String firstName, String midName, String year, String phone0, String phone1, String phone2, String phone3, String phone4) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.midName = midName;
        this.year = year;
        this.phone0 = phone0;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.phone4 = phone4;
        phoneList.add(phone);
            }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getPhone0() {
        return phone0;
    }

    public void setPhone0(String phone0) {
        this.phone0 = phone0;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public String getPhone4() {
        return phone4;
    }

    public void setPhone4(String phone4) {
        this.phone4 = phone4;
    }

    /*public Set<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(Set<Phone> phoneList) {
        this.phoneList = phoneList;

    }*/

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }
}