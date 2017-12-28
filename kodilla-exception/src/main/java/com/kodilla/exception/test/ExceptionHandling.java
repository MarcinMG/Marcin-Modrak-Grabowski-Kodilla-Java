package com.kodilla.exception.test;

public class ExceptionHandling extends Exception {

    public static void main(String args[]) {

        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            System.out.println(secondChallenge.probablyIWillThrowException(3.0, 2.0) );
        }catch (com.kodilla.exception.test.ExceptionHandling e) {
            System.out.println("bad argument x or/and y");
        }finally {
            System.out.println("finally");
        }

    }
}
