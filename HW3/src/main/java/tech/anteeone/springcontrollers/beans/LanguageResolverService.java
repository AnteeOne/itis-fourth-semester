package tech.anteeone.springcontrollers.beans;

import java.util.HashMap;

public class LanguageResolverService {

    private HashMap<String,String> locales;

    public LanguageResolverService() {
        locales = new HashMap<>();
        locales.put("RU","az");
        locales.put("US","en");
    }

    public String resolveLanguage(String country){
        if(!locales.containsKey(country)) return "en";
        return locales.get(country);
    }
}
