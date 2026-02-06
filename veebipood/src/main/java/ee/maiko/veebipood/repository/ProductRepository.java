package ee.maiko.veebipood.repository;

import ee.maiko.veebipood.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//repository -> andmebaasiga suhtlemiseks, tema sees on kõik funktsioonid, mida on võimalik andmebaasiga teha

public interface ProductRepository extends JpaRepository<Product, Long> {

    Long id(Long id);
}
