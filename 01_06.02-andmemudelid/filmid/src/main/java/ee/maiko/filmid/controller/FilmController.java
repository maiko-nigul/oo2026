package ee.maiko.filmid.controller;

import ee.maiko.filmid.entity.Film;
import ee.maiko.filmid.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping("films")
    public List<Film> getFilm() {
        return filmRepository.findAll();
    }

    @DeleteMapping("films/{id}")
    public List<Film> deleteFilm(@PathVariable Long id) {
        filmRepository.deleteById(id);
        return filmRepository.findAll();
    }

    @PostMapping("films")
    public List<Film> postFilm(@RequestBody Film film) {
        filmRepository.save(film);
        return filmRepository.findAll();
    }

}
