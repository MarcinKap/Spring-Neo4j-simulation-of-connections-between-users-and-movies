package guru.springframework.controllers;

import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.MovieRepository;
import guru.springframework.repositories.PersonRepository;
import guru.springframework.services.SavingService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@Controller
public class HomeController {


    PersonRepository personRepository;
    MovieRepository movieRepository;
    CategoryRepository categoryRepository;
    SavingService savingService;

    @GetMapping("/")
    public String homePage(Model model,
                           @Param(value = "fail") String fail,
                           @Param(value = "fail") String fail2) {

        model.addAttribute("users", personRepository.findAllOrOrderByName());
        model.addAttribute("movies", movieRepository.findAllOrderByTitle());
        model.addAttribute("categories", categoryRepository.findAllOrOrderByName());
        model.addAttribute("fail", fail);
        model.addAttribute("fail2", fail2);

        return "index";
    }

    @PostMapping("/import-data")
    public String importData(Model model,
                                   @RequestParam(value = "path") String path) {

        try {
            savingService.LoadDataFromJSONFile(path);
        }
        catch(Exception e) {
            if(e.getMessage() == "Scalar response queries must only return one column. Make sure your cypher query only returns one item.")
            return "redirect:/?fail=False";
            else
                return "redirect:/?fail=True";
        }
        return "redirect:/";
    }


    @PostMapping("/import-movies")
    public String importMoviesFromJSON(Model model,
                             @RequestParam(value = "path") String path) {

        try {
            movieRepository.importMoviesFromJSONFile(path);
        }
        catch(Exception e) {
                return "redirect:/?fail2=True";
        }
        return "redirect:/";
    }

    @GetMapping("/delete-data")
    public String deleteData(Model model) {

        personRepository.deleteAllRelationshipsAndNodes();

        return "redirect:/";
    }


}