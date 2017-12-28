package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;


public class ExceptionModuleRunner {

    public static void main(String args[]) {

        FileReader fileReader = new FileReader();

        try {
            fileReader.readFile();
        } catch (com.kodilla.exception.io.FileReaderException e) {
            System.out.println("problem while reading a file!");
        }
    }
}
