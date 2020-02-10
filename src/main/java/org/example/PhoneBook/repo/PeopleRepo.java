package org.example.PhoneBook.repo;

import org.example.PhoneBook.People;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PeopleRepo extends CrudRepository<People, Long> {
    List<People> findById(Integer id);
    void deleteById(Integer id);
    List<People> findByPhone0ContainingOrPhone1ContainingOrPhone2ContainingOrPhone3ContainingOrPhone4Containing(String phone0,String phone1,String phone2,String phone3,String phone4);
    List<People> findByLastNameContainingAndFirstNameContainingAndMidNameContaining(String lastName,String firstName,String midName);
    List<People> findByLastNameContainingOrFirstNameContainingOrMidNameContaining(String lastName,String firstName,String midName);
    @Query("select p from People p where ((p.lastName like %?1%) and (p.firstName like %?2%)) or ((p.firstName like %?1%) and (p.midName like %?2%))")
    List<People> findTwoName(String Name1, String Name2);
}