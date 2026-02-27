package ee.maiko.rentalstore.repository;

import ee.maiko.rentalstore.entity.Film;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<@NonNull Film,@NonNull Long> {
    List<Film> findByDays(Integer days);
}
