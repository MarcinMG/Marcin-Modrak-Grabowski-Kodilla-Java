package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService{
    public void inform(User user){
        System.out.println("Send mail to " + user.getName() + " ...ok");
    }
}
