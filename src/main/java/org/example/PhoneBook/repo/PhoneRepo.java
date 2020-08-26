package org.example.PhoneBook.repo;

import org.example.PhoneBook.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepo extends CrudRepository<Phone, Long> {

}