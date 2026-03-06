package ee.maiko.Sonade.loputahed.repository;

import ee.maiko.Sonade.loputahed.entity.ReverseWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReverseWordRepository extends JpaRepository<ReverseWord,Long> {
}
