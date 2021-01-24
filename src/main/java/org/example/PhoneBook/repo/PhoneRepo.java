package org.example.PhoneBook.repo;

import org.example.PhoneBook.Phone;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhoneRepo extends CrudRepository<Phone, Long> {
    List<Phone> findByPhoneContaining(String phone);


}