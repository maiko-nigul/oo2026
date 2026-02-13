package ee.maiko.veebipood.repository;

import ee.maiko.veebipood.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//JPArepository -> andmebaasiga suhtlemiseks, tema sees on kõik funktsioonid, mida on võimalik andmebaasiga teha
//CrudRepository -> minimaalsed vajalikud (standartsed) funktsioonid
//PagingAndSortingRepository -> funktsioonid lehekülgede andmete väljastamiseks ja sorteerimiseks
public interface ProductRepository extends JpaRepository<Product, Long> {

    Long id(Long id);
}
