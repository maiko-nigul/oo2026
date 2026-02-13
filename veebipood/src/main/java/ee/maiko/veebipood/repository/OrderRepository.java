package ee.maiko.veebipood.repository;

import ee.maiko.veebipood.entitiy.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
