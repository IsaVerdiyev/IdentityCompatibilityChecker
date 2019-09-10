package com.Matcher.Services;

import com.Matcher.Interfaces.DublicateCharRemover;
import org.springframework.stereotype.Service;

@Service
public class DublicatesRemoverImpl implements DublicateCharRemover {
    @Override
    public String removeDublicates(String str) {
       StringBuilder stringBuilder = new StringBuilder(str);
        int i = 0;
        while(i < stringBuilder.length() - 1){
            if(stringBuilder.charAt(i) == stringBuilder.charAt(i+1)){
               stringBuilder.deleteCharAt(i+1);
                i--;
            }
            i++;
        }
        return stringBuilder.toString();
    }
}
