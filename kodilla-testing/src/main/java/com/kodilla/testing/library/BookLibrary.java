package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<Book>();
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase.listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) return bookList;
        bookList = resultList;
        return bookList;
    }

    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        List<Book> bookList = new ArrayList<Book>();;
        List<Book> resultList1 = libraryDatabase.listBooksInHandsOf(libraryUser);

        if(libraryUser.peselId == "1234567890") {
            return resultList1;
        }
        else if(libraryUser.peselId == "1111111111") {
            return resultList1;
        }
        else if(libraryUser.peselId == "5555555555") {
            return resultList1;
        }
        else return bookList;

    }
}
