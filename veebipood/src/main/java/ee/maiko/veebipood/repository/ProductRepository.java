package ee.maiko.veebipood.repository;

import ee.maiko.veebipood.entitiy.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JPArepository -> andmebaasiga suhtlemiseks, tema sees on kõik funktsioonid, mida on võimalik andmebaasiga teha
//CrudRepository -> minimaalsed vajalikud (standartsed) funktsioonid
//PagingAndSortingRepository -> funktsioonid lehekülgede andmete väljastamiseks ja sorteerimiseks
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByCategoryId(Pageable pageable, Long categoryId);
    Long id(Long id);
}
