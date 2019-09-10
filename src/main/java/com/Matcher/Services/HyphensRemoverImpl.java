package com.Matcher.Services;

import com.Matcher.Interfaces.HyphenRemover;
import org.springframework.stereotype.Service;

@Service
public class HyphensRemoverImpl implements HyphenRemover {
    @Override
    public String removeHyphens(String word) {
        return word.replaceAll("-", "");
    }
}
