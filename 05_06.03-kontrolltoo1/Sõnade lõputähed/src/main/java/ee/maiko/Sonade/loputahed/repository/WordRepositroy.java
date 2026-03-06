package ee.maiko.Sonade.loputahed.repository;

import ee.maiko.Sonade.loputahed.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepositroy extends JpaRepository<Word,Long> {
    @Query (value = "SELECT RIGHT (word, 1) FROM word", nativeQuery = true)
    List<String> findAllLastChars();
    @Query (value = "SELECT LENGTH(word) FROM word", nativeQuery = true)
    List<String> findAllLength();
    @Query (value = "SELECT REVERSE(word) FROM word", nativeQuery = true)
    List<String> findAllReverse();
    @Query(value = "SELECT RIGHT(word, 1) FROM word GROUP BY RIGHT(word, 1) ORDER BY COUNT(*) DESC LIMIT 1", nativeQuery = true)
    String findMostFrequentLastChar();
}
