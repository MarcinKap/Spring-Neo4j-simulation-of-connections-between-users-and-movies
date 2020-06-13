package guru.springframework.controllers;

import guru.springframework.models.Movie;
import guru.springframework.models.Relationships.MovieToCategory;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.MovieRepository;
import guru.springframework.repositories.PersonRepository;
import guru.springframework.repositories.RealationshipsRepositories.MoviesToCategoryRelationRepository;
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
    CategoryRepository categoryRepository;
    MoviesToCategoryRelationRepository moviesToCategoryRelationRepository;


    @GetMapping("/movie-form")
    public String movieForm(Model model) {

        return "movie-form.html";
    }

    @PostMapping("/movie-form-save")
    public String movieFormSave(Model model,
                               @RequestParam(value = "title") String title,
                               @RequestParam(value = "year_of_production") Long year_of_production) {



        movieRepository.saveMovie(title, year_of_production);

//        Movie movie = new Movie();
//        movie.setTitle(title);
//        movie.setYear_of_production(year_of_production);
//        movieRepository.save(movie);

        return "redirect:/movie-form";
    }

    @GetMapping("/movie-data")
    public String movieData(Model model, @RequestParam(value = "id") Long id){

        model.addAttribute("movie", movieRepository.findById(id));
        model.addAttribute("categories", categoryRepository.findAllOrOrderByName());

        model.addAttribute("movieCategories", categoryRepository.findByMovieId(id));

        model.addAttribute("people", personRepository.findByMovieId(id));



        return "movie-data";
    }


    @PostMapping("/movie-add-category")
    public String movieAddCategory(Model model,
                                @RequestParam(value = "movie_id") Long movie_id,
                                @RequestParam(value = "category_id") Long category_id) {

        moviesToCategoryRelationRepository.saveRelationship(movie_id, category_id);


//        MovieToCategory movieToCategory = new MovieToCategory();
//        movieToCategory.setCategory(categoryRepository.findById(category_id).orElse(null));
//        movieToCategory.setMovie(movieRepository.findById(movie_id).orElse(null));
//        moviesToCategoryRelationRepository.save(movieToCategory);

        return "redirect:/movie-data?id=" +movie_id;
    }



}
