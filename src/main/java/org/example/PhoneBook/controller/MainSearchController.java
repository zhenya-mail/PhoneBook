package org.example.PhoneBook.controller;

import org.example.PhoneBook.People;
import org.example.PhoneBook.repo.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class SearchController {
    @Autowired
    private PeopleRepo peopleRepo;

    @GetMapping("/")
    public String search(@RequestParam(required = false, defaultValue = "") String search, Map<String, Object> model) {
        Iterable<People> viewP = null;// = peopleRepo.findAll();
        search = search.trim();
        search = search.replaceAll("\\s+", " ");
        String[] searchFIO = search.split(" ");
        if (searchFIO.length == 1 && searchFIO[0] != null && !searchFIO[0].isEmpty() && searchFIO[0].matches("\\d+")) {
            viewP = peopleRepo.findByPhone0ContainingOrPhone1ContainingOrPhone2ContainingOrPhone3ContainingOrPhone4Containing(searchFIO[0], searchFIO[0], searchFIO[0], searchFIO[0], searchFIO[0]);
        } else {
            if (searchFIO.length == 1) {
                if (searchFIO[0] != null && !searchFIO[0].isEmpty() && !searchFIO[0].matches("\\d")) {

                    viewP = peopleRepo.findByLastNameContainingOrFirstNameContainingOrMidNameContaining(searchFIO[0], searchFIO[0], searchFIO[0]);
                }

            }
            if (searchFIO.length == 2) {
                if (searchFIO[0] != null && !searchFIO[0].isEmpty()
                        && searchFIO[1] != null && !searchFIO[1].isEmpty()) {
                    viewP = peopleRepo.findTwoName(searchFIO[0], searchFIO[1]);

                }
            }

            if (searchFIO.length == 3) {
                if (searchFIO[0] != null && !searchFIO[0].isEmpty()
                        && searchFIO[1] != null && !searchFIO[1].isEmpty()
                        && searchFIO[2] != null && !searchFIO[2].isEmpty()) {
                    viewP = peopleRepo.findByLastNameContainingIgnoreCaseAndFirstNameContainingIgnoreCaseAndMidNameContainingIgnoreCase(searchFIO[0], searchFIO[1], searchFIO[2]);

                }
            }
        }
        if (viewP == null) {
            viewP = peopleRepo.findAll();
        }
        model.put("viewP", viewP);
        model.put("search", search);
        return "main";
    }
}
