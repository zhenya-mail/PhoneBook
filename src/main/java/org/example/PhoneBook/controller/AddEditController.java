package org.example.PhoneBook.controller;

import org.example.PhoneBook.People;
import org.example.PhoneBook.repo.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@Controller
public class AddEditController {
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
        return "redirect:/";

    }

    @PostMapping("/edit")
    public String edit(
            @RequestParam(required = false) Integer id, Map<String, Object> model) {
        Iterable<People> viewP;
        if (id != null) {
            viewP = peopleRepo.findById(id);
        } else {
            viewP = null;
        }

        model.put("viewP", viewP);
        return "edit";
    }

    @PostMapping("/edited")
    public String edited(
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
       // peopleRepo
        return "redirect:/";

    }
    @Transactional
    @PostMapping("/del")
    public String del(
            @RequestParam(required = true) Integer id
    ) {
        peopleRepo.deleteById(id);
        return "redirect:/";
    }



}
