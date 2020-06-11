package guru.springframework.controllers;

import guru.springframework.models.Movie;
import guru.springframework.repositories.MovieRepository;
import guru.springframework.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@AllArgsConstructor
@Controller
public class MovieController {

    PersonRepository personRepository;

    MovieRepository movieRepository;




    @GetMapping("/movie-form")
    public String userForm(Model model) {

        return "movie-form.html";
    }

    @PostMapping("/movie-form-save")
    public String userFormSave(Model model,
                               @RequestParam(value = "title") String title,
                               @RequestParam(value = "year_of_production") Long year_of_production) {


        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setYear_of_production(year_of_production);
        movieRepository.save(movie);

        return "redirect:/";
    }




}
