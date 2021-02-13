package com.sda.kadry.controller;

import com.sda.kadry.model.Person;
import com.sda.kadry.model.PersonDto;
import com.sda.kadry.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/kadry")
public class KadryController {

    @Autowired
    PersonRepository personRepository;

    @ResponseBody
    @GetMapping("/test")
    public String test() {
        return "To jest test";
    }

    @GetMapping("/witaj")
    public String witaj(Model model) {
        model.addAttribute("imie","Janek");
        return "witaj";
    }

    @GetMapping("/dodaj")
    public String getAddPersonForm(Model model) {
        model.addAttribute("personDto", new PersonDto());
        return "person-add";
    }

    @PostMapping("/dodaj")
    public String addPersonToDatabase(@Valid @ModelAttribute PersonDto personDto, Errors errors) {
        if (errors.hasErrors()) {
            return "person-add";
        } else {
            personRepository.save(new Person(personDto.getFirstName()
                    , personDto.getLastName(), personDto.getSalary()));
            return "redirect:/kadry/dodany";
        }

    }

    @GetMapping("/dodany")
    public String personAdded() {
        return "person-added";
    }

}
