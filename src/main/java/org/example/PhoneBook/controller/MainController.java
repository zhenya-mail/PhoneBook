package org.example.PhoneBook.controller;

import org.example.PhoneBook.People;
import org.example.PhoneBook.repo.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private PeopleRepo peopleRepo;

    @Transactional
    @PostMapping("/del")
    public String del(
            @RequestParam(required = true) Integer id
    ) {
        peopleRepo.deleteById(id);
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
}