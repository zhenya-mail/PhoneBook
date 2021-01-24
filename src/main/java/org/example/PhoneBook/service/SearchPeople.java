package org.example.PhoneBook.service;

import org.example.PhoneBook.People;
import org.example.PhoneBook.Phone;
import org.example.PhoneBook.repo.PeopleRepo;
import org.example.PhoneBook.repo.PhoneRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchPeople {
    private final PeopleRepo peopleRepo;
    private final PhoneRepo phoneRepo;

    public SearchPeople(PeopleRepo peopleRepo, PhoneRepo phoneRepo) {
        this.peopleRepo = peopleRepo;
        this.phoneRepo = phoneRepo;
    }

    public List<People> searchPeople(String search) {
        List<People> viewP = null;
        search = search.trim();
        search = search.replaceAll("\\s+", " ");
        String[] searchFIO = search.split(" ");
        if (searchFIO.length == 1 && searchFIO[0] != null && !searchFIO[0].isEmpty() && searchFIO[0].matches("\\d+")) {
            List<Long> peopleId = phoneRepo.findByPhoneContaining(
                    searchFIO[0])
                    .stream()
                    .map(Phone::getId)
                    .collect(Collectors.toList());
            viewP = (List<People>) peopleRepo.findAllById(peopleId);
        } else {
            if (searchFIO.length == 1) {
                if (searchFIO[0] != null && !searchFIO[0].isEmpty() && !searchFIO[0].matches("\\d")) {

                    viewP = peopleRepo.findByLastNameContainingIgnoreCaseOrFirstNameContainingIgnoreCaseOrMidNameContainingIgnoreCase(searchFIO[0], searchFIO[0], searchFIO[0]);
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
        return viewP;
    }

}
