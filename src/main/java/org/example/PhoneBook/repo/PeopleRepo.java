package org.example.PhoneBook.repo;

import org.example.PhoneBook.People;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PeopleRepo extends CrudRepository<People, Long> {
    Optional<People> findById(Long id);
    void deleteById(Long id);
    List<People> findByLastNameContainingIgnoreCaseAndFirstNameContainingIgnoreCaseAndMidNameContainingIgnoreCase(String lastName,String firstName,String midName);
    List<People> findByLastNameContainingIgnoreCaseOrFirstNameContainingIgnoreCaseOrMidNameContainingIgnoreCase(String lastName,String firstName,String midName);
    @Query("select p from People p where ((upper(p.lastName) like concat ('%',upper(?1),'%')) and (upper(p.firstName) like concat('%',upper(?2),'%'))) or ((upper(p.firstName) like concat ('%',upper(?1),'%')) and (upper(p.midName) like concat ('%',upper(?2),'%')))")
    List<People> findTwoName(String Name1, String Name2);
}