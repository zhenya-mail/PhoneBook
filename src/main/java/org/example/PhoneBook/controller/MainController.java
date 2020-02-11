package org.example.PhoneBook.controller;

import org.example.PhoneBook.People;
import org.example.PhoneBook.repo.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private PeopleRepo peopleRepo;

    @GetMapping("/")
    public String search(@RequestParam(required = false, defaultValue = "") String search, Map<String, Object> model) {
        Iterable<People> viewP = peopleRepo.findAll();
        search = search.trim();
        search = search.replaceAll("\\s+"," ");
        String[] searchFIO = search.split(" ");
        if (searchFIO.length == 1 && searchFIO[0] != null && !searchFIO[0].isEmpty() && searchFIO[0].matches("\\d+")){
            viewP = peopleRepo.findByPhone0ContainingOrPhone1ContainingOrPhone2ContainingOrPhone3ContainingOrPhone4Containing(searchFIO[0],searchFIO[0],searchFIO[0],searchFIO[0],searchFIO[0]);
        }else {
            if (searchFIO.length == 1){
                if ( searchFIO[0] != null && !searchFIO[0].isEmpty() && !searchFIO[0].matches("\\d")) {

                    viewP = peopleRepo.findByLastNameContainingOrFirstNameContainingOrMidNameContaining(searchFIO[0], searchFIO[0], searchFIO[0]);
                }

            }
            if (searchFIO.length == 2){
                    if( searchFIO[0] != null && !searchFIO[0].isEmpty()
                    && searchFIO[1] != null && !searchFIO[1].isEmpty()) {
                        viewP = peopleRepo.findTwoName(searchFIO[0],searchFIO[1]);

            }}

            if (searchFIO.length == 3) {
                if (searchFIO[0] != null && !searchFIO[0].isEmpty()
                        && searchFIO[1] != null && !searchFIO[1].isEmpty()
                        && searchFIO[2] != null && !searchFIO[2].isEmpty()) {
                    viewP = peopleRepo.findByLastNameContainingAndFirstNameContainingAndMidNameContaining(searchFIO[0], searchFIO[1], searchFIO[2]);

                }
            }
        }
        model.put("viewP", viewP);
        model.put("search", search);
        return "main";
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

        model.put("viewP", viewP);
        model.put("Ok", "Успешно изменено");
        return "edit";

    }

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