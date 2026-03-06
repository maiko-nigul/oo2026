package ee.maiko.Sonade.loputahed.service;

import ee.maiko.Sonade.loputahed.entity.ReverseWord;
import ee.maiko.Sonade.loputahed.entity.Word;
import ee.maiko.Sonade.loputahed.repository.WordRepositroy;
import ee.maiko.Sonade.loputahed.repository.ReverseWordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class WordService {

    private WordRepositroy  wordRepositroy;
    private ReverseWordRepository reverseWordRepository;

    public  void validate(Word word){
        if (word.getId() != null) {
            throw new RuntimeException("New word record cannot have a pre-defined ID.");
        }
        if(word.getWord() == null || word.getWord().isEmpty()){
            throw new RuntimeException("New word record cannot have a pre-defined word.");
        }
    }

    public void reverseAndSaveAll() {
        List<String> reversedStrings = wordRepositroy.findAllReverse();
        List<ReverseWord> toSave = new ArrayList<>();
            for (String s : reversedStrings) {
                toSave.add(new ReverseWord(s));
            }
        reverseWordRepository.saveAll(toSave);
    }
}
