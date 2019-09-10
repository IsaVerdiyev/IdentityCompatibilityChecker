package com.Matcher.Services;

import com.Matcher.Interfaces.Comparer;
import com.Matcher.Interfaces.WordTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SymbolsComparator implements Comparer {
    @Autowired
    private WordTransformer wordTransformer;

    public SymbolsComparator(WordTransformer wordTransformer) {
        this.wordTransformer = wordTransformer;
    }

    @Override
    public boolean match(String checkedWord, String comparisonWord) {
        return wordTransformer.recieveTransformedWord(checkedWord).equals(wordTransformer.recieveTransformedWord(comparisonWord));
    }
}
