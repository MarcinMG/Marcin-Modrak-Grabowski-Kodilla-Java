package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //given
        Library library = new Library("Publiczna");
        for(int i=1; i<6; i++) {
            library.getBooks().add(new Book("Ksiązka"+i, "Nieznany", LocalDate.of(1999, 01, i)));
        }
        //making a shallow clone of object board
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Project number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //making a deep copy of object board
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Project number 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        //When
        library.getBooks().add(new Book("Nowa", "Różni", LocalDate.of(1999, 12, 12)));
        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(6, library.getBooks().size());
        Assert.assertEquals(6, clonedLibrary.getBooks().size());
        Assert.assertEquals(5, deepClonedLibrary.getBooks().size());
    }
}
