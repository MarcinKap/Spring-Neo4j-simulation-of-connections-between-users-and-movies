package guru.springframework.controllers;

import guru.springframework.models.Category;
import guru.springframework.models.Movie;
import guru.springframework.repositories.CategoryRepository;
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
public class CategoryController {

    PersonRepository personRepository;

    MovieRepository movieRepository;

    CategoryRepository categoryRepository;



    @GetMapping("/category-form")
    public String userForm(Model model) {

        return "category-form.html";
    }

    @PostMapping("/category-form-save")
    public String userFormSave(Model model,
                               @RequestParam(value = "name") String name) {


        Category category = new Category();
        category.setName(name);
//        movie.setYear_of_production(year_of_production);
        categoryRepository.save(category);

        return "redirect:/";
    }


}