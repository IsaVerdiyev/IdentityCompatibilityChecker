package com.Matcher.Services;

import com.Matcher.Interfaces.OtherWordsRemover;

public class OtherWordsRemoverImpl implements OtherWordsRemover {

    @Override
    public String removeOtherWords(String word) {
        return word.replaceAll("oglu|ogli|oğlu|qızı|oğli|oqlu|oqlı|oqli]", "");
    }
}
