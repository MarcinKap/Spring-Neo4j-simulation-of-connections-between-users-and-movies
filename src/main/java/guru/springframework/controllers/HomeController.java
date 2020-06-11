package guru.springframework.controllers;

import guru.springframework.models.Person;
import guru.springframework.models.Relationships.PersonToPerson;
import guru.springframework.repositories.CategoryRepository;
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
    CategoryRepository categoryRepository;

    @GetMapping("/")
    public String homePage(Model model) {

        model.addAttribute("users", personRepository.findAll());
        model.addAttribute("movies", movieRepository.findAll());

        model.addAttribute("categories", categoryRepository.findAll());


        return "index";
    }



}