package ee.maiko.rentalstore.repository;

import ee.maiko.rentalstore.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
