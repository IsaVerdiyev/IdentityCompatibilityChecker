package com.Matcher.Services;

import com.Matcher.Interfaces.PatternsRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class HardCodePatternsGetter implements PatternsRepository {

    @Override
    public Map<String, String> recievePatternsMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("kh|h", "x");
        map.put("ə|e", "a");
        map.put("sh", "w");
        map.put("ı", "i");
        return map;
    }
}
