package ee.maiko.decathlon.repository;

import ee.maiko.decathlon.entity.Athlete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    Page<Athlete> findByCountry(String country, Pageable pageable);
}