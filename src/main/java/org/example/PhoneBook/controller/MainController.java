package org.example.PhoneBook.controller;

import org.example.PhoneBook.People;
import org.example.PhoneBook.repo.PeopleRepo;
import org.example.PhoneBook.service.SearchPeople;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private final PeopleRepo peopleRepo;
    private final SearchPeople searchService;

    public MainController(PeopleRepo peopleRepo, SearchPeople searchService) {
        this.peopleRepo = peopleRepo;
        this.searchService = searchService;
    }

    @GetMapping("/")
    public String searchAndMain(@RequestParam(required = false, defaultValue = "") String search, Map<String, Object> model) {
        List<People> viewP = searchService.searchPeople(search);
        if (viewP == null) {
            viewP = (List<People>) peopleRepo.findAll();
        }
        model.put("viewP", viewP);
        model.put("search", search);
        return "main";
    }
}
