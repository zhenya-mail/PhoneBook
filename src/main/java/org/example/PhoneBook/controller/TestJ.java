package org.example.PhoneBook.controller;

import org.example.PhoneBook.People;
import org.example.PhoneBook.repo.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestJ {
@Autowired
private PeopleRepo peopleRepo;
    @GetMapping("/123")
    public Iterable<People> jtest() {
        final Iterable<People> data = peopleRepo.findAll();
        List<People> returnList = new ArrayList<>();
        data.forEach(returnList::add);
        return data;
    }
}
