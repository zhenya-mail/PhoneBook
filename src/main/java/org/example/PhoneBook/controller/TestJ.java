package org.example.PhoneBook.controller;

import org.example.PhoneBook.People;
import org.example.PhoneBook.repo.PeopleRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestJ {
    private final PeopleRepo peopleRepo;

    public TestJ(PeopleRepo peopleRepo) {
        this.peopleRepo = peopleRepo;
    }


    @GetMapping("/123")
    public Iterable<People> jTest() {
        final Iterable<People> data = peopleRepo.findAll();
        List<People> returnList = new ArrayList<>();
        data.forEach(returnList::add);
        return returnList;
    }
}
