package ee.maiko.filmid.repository;

import ee.maiko.filmid.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
    Long id(Long id);
}
