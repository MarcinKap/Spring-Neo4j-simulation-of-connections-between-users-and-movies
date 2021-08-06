package guru.springframework.controllers;

import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.MovieRepository;
import guru.springframework.repositories.PersonRepository;
import guru.springframework.repositories.RealationshipsRepositories.PersonToMovieRelationshipRepository;
import guru.springframework.repositories.RealationshipsRepositories.PersonToPersonRealtionRepository;
import guru.springframework.services.SavingService;
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
    MovieRepository movieRepository;
    CategoryRepository categoryRepository;
    PersonToMovieRelationshipRepository personToMovieRelationshipRepository;
    SavingService savingService;


    @GetMapping("/user-form")
    public String userForm(Model model) {

        return "user-form.html";
    }

    @PostMapping("/user-form-save")
    public String userFormSave(Model model,
                               @RequestParam(value = "name") String name,
                               @RequestParam(value = "surname") String surname,
                               @RequestParam(value = "age") Long age) {
        personRepository.savePerson(name, surname, age);
        return "redirect:/";
    }

    @GetMapping("/person-data")
    public String personData(Model model, @RequestParam(value = "id") Long id) {

//        Dane przeglądanej osoby
        model.addAttribute("person", personRepository.findById(id));
//      Oglądnięte filmy
        model.addAttribute("viewed_movies", movieRepository.findViewedMoviesByPersonId(id));
//        Filmy które Cię zainteresowały
        model.addAttribute("insteresing_movies", movieRepository.findnteresingMoviesByPersonId(id));

//        Wszystkie filmy
        model.addAttribute("movies", movieRepository.findAll());

//        Proponowane filmy
//        model.addAttribute("suggested_movies", movieRepository.findAll());
        model.addAttribute("suggested_movies", movieRepository.findSuggestedMovies(id));

//        Znajomi uzytkownicy
        model.addAttribute("friends", personRepository.findByPersonId(id));

        //      Proponowani znajomi
        model.addAttribute("proposed_friends", personRepository.findProposedPeopleForFriendship(id));

        //      Użytkownicy których możesz dodać
        model.addAttribute("people", personRepository.findByPeopleForFriendship(id));

        return "person-data";
    }


    @PostMapping("/person-add-viewed-movies")
    public String PersonAddViewedMovies(Model model,
                                        @RequestParam(value = "person_id") Long id,
                                        @RequestParam(value = "movie_id") Long movie_id) {
        personToMovieRelationshipRepository.saveViewedMovie(id, movie_id);
        return "redirect:person-data?id=" + id;
    }

    @PostMapping("/person-add-interesting-movies")
    public String PersonAddInteresingMovies(Model model,
                                        @RequestParam(value = "person_id") Long id,
                                        @RequestParam(value = "movie_id") Long movie_id) {
        personToMovieRelationshipRepository.saveInterestedMovie(id, movie_id);
        return "redirect:person-data?id=" + id;
    }





    @PostMapping("/person-add-friend-relationship")
    public String personAddFriendRealtionship(Model model,
                                              @RequestParam(value = "person_id") Long id,
                                              @RequestParam(value = "new_friend_id") Long new_friend_id) {
        savingService.saveRelationshipPersonToPerson(id, new_friend_id);

        return "redirect:person-data?id=" + id;
    }


    @PostMapping("/delete-viewed-movie")
    public String deleteViewedMovie(Model model,
                                    @RequestParam(value = "person_id") Long id,
                                    @RequestParam(value = "movie_to_delete") Long movie_to_delete) {

        personToMovieRelationshipRepository.deleteByPersonIdANDMovieId(movie_to_delete, id);

        return "redirect:person-data?id=" + id;
    }
    @PostMapping("/delete-interesing-movie")
    public String deleteInteresingMovie(Model model,
                                    @RequestParam(value = "person_id") Long id,
                                    @RequestParam(value = "movie_to_delete") Long movie_to_delete) {
        personToMovieRelationshipRepository.deleteInteresingMovieByPersonIdANDMovieId(movie_to_delete, id);
        return "redirect:person-data?id=" + id;
    }

}