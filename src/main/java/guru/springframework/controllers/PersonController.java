package guru.springframework.controllers;

import guru.springframework.models.Movie;
import guru.springframework.models.Person;
import guru.springframework.models.Relationships.MovieToCategory;
import guru.springframework.models.Relationships.PersonToMovie;
import guru.springframework.models.Relationships.PersonToPerson;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.MovieRepository;
import guru.springframework.repositories.PersonRepository;
import guru.springframework.repositories.RealationshipsRepositories.PersonToMovieRelationshipRepository;
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
    MovieRepository movieRepository;
    CategoryRepository categoryRepository;
    PersonToMovieRelationshipRepository personToMovieRelationshipRepository;

    @GetMapping("/user-form")
    public String userForm(Model model) {

//        Person person = new Person();
//        person.setName("Osoba1");
//        person.setSurname("Nazw1");
//        person.setAge(new Long(23));
//        personRepository.save(person);
//
//        Person person2 = new Person();
//        person.setName("Osoba2");
//        person.setSurname("Nazw2");
//        person.setAge(new Long(42));
//        personRepository.save(person);
//
//
//
//
//
//
//        Person finded = personRepository.findById(new Long(63)).orElse(null);
//        Person finded2 = personRepository.findById(new Long(43)).orElse(null);
//
//        PersonToPerson personToPerson = new PersonToPerson();
//        personToPerson.setPerson(finded);
//        personToPerson.setPerson_2(finded2);
//
//        personToPersonRealtionRepository.save(personToPerson);





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

    @GetMapping("/person-data")
    public String personData(Model model, @RequestParam(value = "id") Long id){

//        Dane przeglądanej osoby
        model.addAttribute("person", personRepository.findById(id));
//      Oglądnięte filmy
        model.addAttribute("viewed_movies", movieRepository.findByPersonId(id));
//        Wszystkie filmy
        model.addAttribute("movies", movieRepository.findAll());

//        Proponowane filmy
//        model.addAttribute("suggested_movies", movieRepository.findAll());
        model.addAttribute("suggested_movies", movieRepository.findSuggestedMovies(id));


//        Znajomi uzytkownicy
        model.addAttribute("friends", personRepository.findByPersonId(id));
//      Użytkownicy których możesz dodać
        model.addAttribute("people", personRepository.findByPeopleWithoutOneId(id));
        return "person-data";
    }





    @PostMapping("/person-add-viewed-movies")
    public String PersonAddViewedMovies(Model model,
                                   @RequestParam(value = "person_id") Long id,
                                   @RequestParam(value = "movie_id") Long movie_id) {


//        PersonToPerson personToPerson = new PersonToPerson();
//        personToPerson.setPerson(personRepository.findById(person_id).orElse(null));
//        personToPerson.setPerson_2();
        PersonToMovie personToMovie = new PersonToMovie();
        personToMovie.setMovie(movieRepository.findById(movie_id).orElse(null));
        personToMovie.setPerson(personRepository.findById(id).orElse(null));
        personToMovieRelationshipRepository.save(personToMovie);

        return "redirect:person-data?id="+id;
    }



    @PostMapping("/person-add-friend-relationship")
    public String personAddFriendRealtionship(Model model,
                                        @RequestParam(value = "person_id") Long id,
                                        @RequestParam(value = "new_friend_id") Long new_friend_id) {

        PersonToPerson personToPerson = new PersonToPerson();
        personToPerson.setPerson(personRepository.findById(id).orElse(null));
        personToPerson.setPerson_2(personRepository.findById(new_friend_id).orElse(null));
        personToPersonRealtionRepository.save(personToPerson);



        return "redirect:person-data?id="+id;
    }



    @PostMapping("/delete-viewed-movie")
    public String deleteViewedMovie(Model model,
                                              @RequestParam(value = "person_id") Long id,
                                              @RequestParam(value = "movie_to_delete") Long movie_to_delete) {


        personToMovieRelationshipRepository.deleteByPersonIdANDMovieId(movie_to_delete, id);

        return "redirect:person-data?id="+id;
    }


}