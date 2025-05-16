package com.autoria.service;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProfanityService {

    private static final List<String> BAD_WORDS = Arrays.asList("дурак", "ідіот", "лайка");

    public boolean containsProfanity(String text) {
        String cleanText = Jsoup.clean(text, Safelist.none()).toLowerCase();
        return BAD_WORDS.stream().anyMatch(cleanText::contains);
    }
}
