package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.BookA;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //Given
        MedianAdapter adapter = new MedianAdapter();
        Set<BookA> books = new HashSet<>();
        books.add(new BookA("Simone Moro", "Zew Lodu", 2015, "0001"));
        books.add(new BookA("Artur Hajzer", "Atak Rozpaczy", 2011, "0002"));
        books.add(new BookA("Michał Jagiełło", "Wołanie w górach", 2012, "0003"));
        //When
        int medianPublicationYear = adapter.publicationYearMedian(books);
        //Then
        assertEquals(2012, medianPublicationYear);
    }
}
