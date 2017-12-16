package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Gwiazdki", text -> "***"+text+"***");
        poemBeautifier.beautify("Duży tekst", text -> text.toUpperCase());
        poemBeautifier.beautify("Inny tekst", text -> text.replace(text, "Nowy tekst"));
        poemBeautifier.beautify("Ucięty tekst", text -> text.substring(7));
        poemBeautifier.beautify("   Bez spacji tekst   ", text -> text.trim());
    }
}
