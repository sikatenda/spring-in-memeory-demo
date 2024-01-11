package com.example.springinmemeorydemo.service;

import com.example.springinmemeorydemo.person.Person;
import com.example.springinmemeorydemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAllPerson(){
       return(List<Person>) personRepository.findAll();
    }

    public Person findPersonById(int id){
       Optional<Person> result = personRepository.findById(id);
       if(result.isPresent()){
           return result.get();
       }
       return new Person();
    }

    public Person addPerson(Person person){
       return personRepository.save(person);
    }

    public Person updatePerson(Person person){
        Optional<Person> result = personRepository.findById(person.getId());
        Person existing=result.get();
        existing.setFirstName(person.getFirstName());
        existing.setLastName(person.getLastName());
        existing.setSurname(person.getSurname());
        existing.setDob(person.getDob());
        existing.setGender(person.getGender());
        existing.setEmail(person.getEmail());
        existing.setPhone(person.getPhone());
        existing.setAddress(person.getAddress());
        existing.setSalary(person.getSalary());
        return personRepository.save(existing);
    }

    public void deleteById(int id){
        personRepository.deleteById(id);
    }
}
