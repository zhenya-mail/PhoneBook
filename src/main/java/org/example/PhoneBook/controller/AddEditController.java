package org.example.PhoneBook.controller;

import org.example.PhoneBook.People;
import org.example.PhoneBook.Phone;
import org.example.PhoneBook.repo.PeopleRepo;
import org.example.PhoneBook.repo.PhoneRepo;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AddEditController {
    private final PeopleRepo peopleRepo;
    private final PhoneRepo phoneRepo;

    public AddEditController(PeopleRepo peopleRepo, PhoneRepo phoneRepo) {
        this.peopleRepo = peopleRepo;
        this.phoneRepo = phoneRepo;
    }

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
            String phone0,
            String phone1,
            String phone2,
            String phone3,
            String phone4) {
        People viewPeople = new People(null, lastName, firstName, midName, year);
        peopleRepo.save(viewPeople);
        List<Phone> phoneList = phoneStringToList(peopleRepo.save(viewPeople), phone0,phone1,phone2,phone3,phone4);
        phoneRepo.saveAll(phoneList);
        return "redirect:/";

    }

    @PostMapping("/edit")
    public String edit(
            @RequestParam(required = false) Long id, Map<String, Object> model) {
        List<People> viewP = new ArrayList<>();
        viewP.add(peopleRepo.findById(id).orElse(new People()));
        model.put("viewP", viewP);
        return "edit";
    }

    @PostMapping("/edited")
    public String edited(
            @RequestParam Long id,
            String lastName, String firstName, String midName, String year,
            String phone0, String phone1, String phone2, String phone3, String phone4) {
        People viewPeople = new People(id, lastName, firstName, midName, year);
        List<Phone> phoneList = phoneStringToList(peopleRepo.save(viewPeople),phone0,phone1,phone2,phone3,phone4);
        phoneRepo.saveAll(phoneList);
        return "redirect:/";

    }

    @Transactional
    @PostMapping("/del")
    public String del(@RequestParam Long id) {
        peopleRepo.deleteById(id);
        return "redirect:/";
    }
    private List<Phone> phoneStringToList(People people,String... phoneStrList){
        List<Phone> phoneList = new ArrayList<>();
        for (String phoneStr : phoneStrList) {
            if (phoneStr != null && !phoneStr.isEmpty()) {
                phoneList.add(new Phone(people, phoneStr));
            }
        }
        return phoneList;
    }

}
