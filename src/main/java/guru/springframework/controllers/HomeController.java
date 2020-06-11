package guru.springframework.controllers;

import guru.springframework.models.Person;
import guru.springframework.models.Relationships.PersonToPerson;
import guru.springframework.repositories.MovieRepository;
import guru.springframework.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;


@AllArgsConstructor
@Controller
public class HomeController {


    PersonRepository personRepository;
    MovieRepository movieRepository;

    @GetMapping("/")
    public String homePage(Model model) {

        model.addAttribute("users", personRepository.findAll());
        model.addAttribute("movies", movieRepository.findAll());




//        userService.savecos();
//        userRepository.getUserModel2();


        return "index";
    }

//    @GetMapping("/user-form")
//    public String userForm(Model model) {
//
//        return "user-form.html";
//    }
//
//    @PostMapping("/user-form-save")
//    public String userFormSave(Model model,
//                               @RequestParam(value = "name") String name,
//                               @RequestParam(value = "surname") String surname,
//                               @RequestParam(value = "age") Long age) {
//
//
//        Person person = new Person();
//        person.setName(name);
//        person.setSurname(surname);
//        person.setAge(age);
//        personRepository.save(person);
//
//
//        return "redirect:/";
//    }

}