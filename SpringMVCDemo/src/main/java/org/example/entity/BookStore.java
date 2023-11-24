package org.example.entity;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BookStore {
    public List<Book> bookList = new ArrayList<>();
    public BookStore(){
        bookList.add((new Book(1, "Core Java",
                new String[]{"Horseman", "Deitel"},
                "This is a good book for Java!",
                "PUBLISHED",
                new String[]{"BEST SELLER", "Programming"})));
        bookList.add((new Book(2, "On Java",
                new String[]{"Bruce Ecel"},
                "This is a great book for Java!",
                "PUBLISHED",
                new String[]{"BEST SELLER", "Programming"})));
    }

}
