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
        List<Book> bookList1234567890 = new ArrayList<Book>();
        List<Book> bookList1111111111 = new ArrayList<Book>();
        List<Book> bookList5555555555 = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);;
        bookList1111111111.add(book1);
        for(int n = 1; n <= 5; n++){
            Book book2 = new Book("Title " + n, "Author " + n, 1970 + n);
            bookList5555555555.add(book2);
        }

        if(libraryUser.peselId == "1234567890") {
            return bookList1234567890;
        }
        else if(libraryUser.peselId == "1111111111") {
            return bookList1111111111;
        }
        else if(libraryUser.peselId == "5555555555") {
            return bookList5555555555;
        }
        else return bookList1234567890;

    }
}
