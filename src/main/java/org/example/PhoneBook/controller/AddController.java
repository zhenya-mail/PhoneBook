package org.example.PhoneBook.controller;

import org.example.PhoneBook.People;
import org.example.PhoneBook.repo.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class AddController {
    @Autowired
    private PeopleRepo peopleRepo;

    @GetMapping("/add")
    public String add() {

        return "add";
    }
    @PostMapping("/add")
    public String add(
            @RequestParam String lastName,
            @RequestParam String firstName,
            @RequestParam String midName,
            @RequestParam String year,
            @RequestParam(defaultValue = "") String phone0,
            @RequestParam(defaultValue = "") String phone1,
            @RequestParam(defaultValue = "") String phone2,
            @RequestParam(defaultValue = "") String phone3,
            @RequestParam(defaultValue = "") String phone4,
            Map<String, Object> model) {
        People viewPeople = new People(lastName, firstName, midName, year, phone0, phone1, phone2, phone3, phone4);
        peopleRepo.save(viewPeople);
        Iterable<People> viewP = peopleRepo.findAll();

        model.put("viewP", viewP);
        model.put("Ok", "Успешно добавленно");
        return "add";

    }

    @PostMapping("/added")
    public String added(
            @RequestParam Integer id,
            @RequestParam(defaultValue = "") String lastName,
            @RequestParam(defaultValue = "") String firstName,
            @RequestParam(defaultValue = "") String midName,
            @RequestParam(defaultValue = "") String year,
            @RequestParam(defaultValue = "") String phone0,
            @RequestParam(defaultValue = "") String phone1,
            @RequestParam(defaultValue = "") String phone2,
            @RequestParam(defaultValue = "") String phone3,
            @RequestParam(defaultValue = "") String phone4,
            Map<String, Object> model) {
        People viewPeople = new People(id, lastName, firstName, midName, year, phone0, phone1, phone2, phone3, phone4);
        peopleRepo.save(viewPeople);
        Iterable<People> viewP = peopleRepo.findById(id);
        List<People> view = peopleRepo.findById(id);
        model.put("viewP", viewP);
        model.put("Ok", "Успешно изменено");
        return "redirect:/";

    }
}
