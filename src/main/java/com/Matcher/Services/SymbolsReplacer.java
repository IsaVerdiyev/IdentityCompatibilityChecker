package com.Matcher.Services;

import com.Matcher.Interfaces.DublicateCharRemover;
import com.Matcher.Interfaces.HyphenRemover;
import com.Matcher.Interfaces.PatternsRepository;
import com.Matcher.Interfaces.WordTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.Map;

@Service
public class SymbolsReplacer implements WordTransformer {

    @Autowired
    private PatternsRepository patternsRepository;

    @Autowired
    private DublicateCharRemover dublicateCharRemover;

   /* @Autowired
    private HyphenRemover hyphenRemover;*/

    public SymbolsReplacer(PatternsRepository patternsRepository) {
        this.patternsRepository = patternsRepository;
    }

    @Override
    public String recieveTransformedWord(String initialWord) {
        Map<String, String> map = patternsRepository.recievePatternsMap();
        String resultWord = initialWord.trim().toLowerCase();
        resultWord = dublicateCharRemover.removeDublicates(resultWord);
        //resultWord = hyphenRemover.removeHyphens(resultWord);
        resultWord = Normalizer.normalize(resultWord, Normalizer.Form.NFD).replaceAll("[\\u0300-\\u036F]", "");
        for (Map.Entry<String, String> pair: map.entrySet()){
            resultWord = resultWord.replaceAll(pair.getKey(), pair.getValue());
        }
        resultWord = dublicateCharRemover.removeDublicates(resultWord).trim();
        return resultWord;
    }
}
