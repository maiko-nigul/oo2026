package ee.maiko.Sonade.loputahed.controller;

import ee.maiko.Sonade.loputahed.entity.ReverseWord;
import ee.maiko.Sonade.loputahed.entity.Word;
import ee.maiko.Sonade.loputahed.repository.ReverseWordRepository;
import ee.maiko.Sonade.loputahed.repository.WordRepositroy;
import ee.maiko.Sonade.loputahed.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class WordController {

    private WordRepositroy wordRepositroy;
    private WordService wordService;
    private ReverseWordRepository  reverseWordRepository;

    @PostMapping("words")
    public Word save(@RequestBody Word word) {
        wordService.validate(word);
        return wordRepositroy.save(word);
    }

    @GetMapping("words")
    public List<Word> getAllWords() {
        return wordRepositroy.findAll();
    }

    @GetMapping("words/lastchar")
    public List<String> getAllWordsEnd() {
        return wordRepositroy.findAllLastChars();
    }

    @GetMapping("words/length")
    public List<String> getAllWordsLength() {
        return wordRepositroy.findAllLength();
    }

    @GetMapping("words/reverse")
    public List<ReverseWord> reverseWords() {
        wordService.reverseAndSaveAll();
        return reverseWordRepository.findAll();
    }
    @GetMapping("words/most-frequent")
    public String getMostFrequent() {
        String letter = wordRepositroy.findMostFrequentLastChar();
        return "Sõnade lõpus esineb kõige sagedamini tähte: " +letter ;
    }
}
