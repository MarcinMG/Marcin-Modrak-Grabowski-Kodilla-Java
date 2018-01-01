package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService{
    public void inform(String name, String surName){
        System.out.println("Send mail to " + name + " ...ok");
    }
}
