package ee.maiko.veebipood.repository;

import ee.maiko.veebipood.entitiy.Category;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<@NonNull Category, @NonNull Long> {
}
