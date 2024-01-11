package com.example.springinmemeorydemo.controller;

import com.example.springinmemeorydemo.person.Person;
import com.example.springinmemeorydemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String findAll(Model model){
     model.addAttribute("people",personService.findAllPerson());
     return "index";
    }

    @GetMapping("/add")
    public String lunchAddPersonPage(Model model){
        model.addAttribute("person",new Person());
        return "add-person";
    }

    @PostMapping("/addbook")
    public String createPerson(Person person){
      personService.addPerson(person);
      return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String lunchEditPage(Model model, @PathVariable("id") int id){
        model.addAttribute("person",personService.findPersonById(id));
        return "edit-person";
    }

    @PostMapping("/updateperson")
    public String updatePerson(Person person){
        personService.updatePerson(person);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") int id){
        personService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/test")
    public String test(){
        Person ps= new Person();
        ps.setFirstName("Emile");
        ps.setSurname("Nsuala");
        personService.addPerson(ps);
        return "index";
    }
}
