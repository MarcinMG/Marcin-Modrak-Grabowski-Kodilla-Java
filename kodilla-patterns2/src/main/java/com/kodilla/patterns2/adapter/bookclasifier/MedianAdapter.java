package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.BookA;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookB;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<BookA> bookSet) {
        Map<BookSignature, BookB> mapBooks = new HashMap<>();
        for(BookA books : bookSet) {
            mapBooks.put(new BookSignature(books.getSignature()),
                    new BookB(books.getAuthor(), books.getTitle(), books.getPublicationYear()));
        }
        return medianPublicationYear(mapBooks);
    }
}