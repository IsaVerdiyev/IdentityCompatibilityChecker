package com.Matcher.Services;

import com.Matcher.Interfaces.PatternsRepository;
import com.Matcher.Main;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.corba.se.impl.resolver.INSURLOperationImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Primary
public class JsonPatternsReciever implements PatternsRepository {
    private LinkedHashMap<String, String> patterns;

   /* @Value("classpath:patterns.json")
    private Resource resource;*/
    public JsonPatternsReciever() throws FileNotFoundException, IOException {
        /*Path path = Paths.get(resource.getURI());
       InputStream inputStream = new FileInputStream(Paths.get(resource.getURI()).toAbsolutePath().toString());*/
       InputStream inputStream = this.getClass().getResourceAsStream("/patterns.json");
        System.out.println("inputstream " + inputStream);
        ObjectMapper objectMapper = new ObjectMapper();
        patterns = objectMapper.readValue(inputStream, new TypeReference<Map<String,String>>(){});
    }

    @Override
    public Map<String, String> recievePatternsMap() {
        return patterns;
    }
}
