package ee.maiko.rentalstore.controller;

import ee.maiko.rentalstore.dto.FilmSaveDto;
import ee.maiko.rentalstore.entity.Film;
import ee.maiko.rentalstore.entity.FilmType;
import ee.maiko.rentalstore.repository.FilmRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FilmController {

    private final FilmRepository filmRepository;

    @PostMapping("films")
    public Film saveFilm(@RequestBody FilmSaveDto filmSaveDto){
        Film film = new Film();
        film.setTitle(filmSaveDto.title());
        film.setType(filmSaveDto.type());
        film.setDays(0);
        return filmRepository.save(film);
    }
    @DeleteMapping("films/{id}")
    public void deleteFilm(@PathVariable Long id){
        filmRepository.deleteById(id);
    }

    //PUT - kogu entity muutmise v6imekus
    // PATCh - booking v6etud. tellimus makstud. kogus yhe v6rra v2hendatud.
    @PatchMapping("films/type")
    public Film changeFilmType(@RequestParam Long id, @RequestParam FilmType filmType){
        Film film = filmRepository.findById(id).orElseThrow();
        film.setType(filmType);
        return filmRepository.save(film);
    }
    @GetMapping("films")
    public List<Film> findAll(){
        return filmRepository.findAll();
    }
    @GetMapping("films/available")
    public List<Film> findAllAvaialbe(){
//        List<Film> films = findAll();
//        List<Film> availableFilms = new ArrayList<>();
//        for(Film film : films){
//            if (film.getDays() == 0) {
//                availableFilms.add(film);
//            }
//        }
//        return availableFilms;
        return filmRepository.findByDays(0);
    }
}
