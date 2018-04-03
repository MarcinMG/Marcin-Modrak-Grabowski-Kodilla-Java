package com.kodilla.hibernate.manytomany.facade;

public class ExceptionFacade extends Exception {
    public static String ERR_VALIDATE = "3 or more letters required";

    public ExceptionFacade(String message) {
        super(message);
    }
}
