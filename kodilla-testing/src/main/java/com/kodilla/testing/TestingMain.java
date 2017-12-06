package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        //calculator test
        Calculator calculator = new Calculator();

        if (calculator.add(2,3) == (2+3)){
            System.out.println("add test OK");
        } else {
            System.out.println("add Error!");
        }

        if (calculator.subtract(12, 3) == (12-3)){
            System.out.println("subtract test OK");
        } else {
            System.out.println("subtract Error!");
        }

    }
}