package guru.springframework.controllers;

import guru.springframework.models.Person;
import guru.springframework.models.Relationships.PersonToPerson;
import guru.springframework.repositories.PersonRepository;
import guru.springframework.repositories.RealationshipsRepositories.PersonToPersonRealtionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@AllArgsConstructor
@Controller
public class PersonController {

    PersonRepository personRepository;
    PersonToPersonRealtionRepository personToPersonRealtionRepository;



    @GetMapping("/user-form")
    public String userForm(Model model) {

        Person person = new Person();
        person.setName("Osoba1");
        person.setSurname("Nazw1");
        person.setAge(new Long(23));
        personRepository.save(person);

        Person person2 = new Person();
        person.setName("Osoba2");
        person.setSurname("Nazw2");
        person.setAge(new Long(42));
        personRepository.save(person);






        Person finded = personRepository.findById(new Long(63)).orElse(null);
        Person finded2 = personRepository.findById(new Long(43)).orElse(null);

        PersonToPerson personToPerson = new PersonToPerson();
        personToPerson.setPerson(finded);
        personToPerson.setPerson_2(finded2);

        personToPersonRealtionRepository.save(personToPerson);





        return "user-form.html";
    }

    @PostMapping("/user-form-save")
    public String userFormSave(Model model,
                               @RequestParam(value = "name") String name,
                               @RequestParam(value = "surname") String surname,
                               @RequestParam(value = "age") Long age) {


        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        person.setAge(age);
        personRepository.save(person);


        return "redirect:/";
    }

}