package com.example.springinmemeorydemo.repository;

import com.example.springinmemeorydemo.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
