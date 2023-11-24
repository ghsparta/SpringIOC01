package org.example.controller;

import org.example.entity.Book;
import org.example.entity.BookStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@Controller
public class HelloController {

    @Autowired
    BookStore bookStore;


    @RequestMapping(value = "/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/hello")
    public String hello(String msg) {//   //set bp
//        System.out.println(msg);
        return "hello";//view name
    }

    @GetMapping("/rest/books")
    public List<Book> findAllBooks() {
        return bookStore.bookList;
    }


    //    /rest/books/id?id=1
    @GetMapping("/rest/books/id")
    public Optional<Book> findBookById(int id) {  //@RequestParam("id")
        Optional<Book> first = bookStore.bookList.stream().
                filter(book -> book.getId() == id).findFirst();
        return first;
    }

    ///rest/books/add
    @PostMapping("/rest/books/add")
    public String addBook(@RequestBody Book book) {
        if (bookStore.bookList.add(book))
            return "Book added";
        else
            return "Book not added";
    }


    //    /api/v1/employee/2
    @PostMapping("/api/v1/employee/{id}")
    public Optional<Book> findBookById2(@PathVariable("id") int id) {
        Optional<Book> first = bookStore.bookList.stream().
                filter(book -> book.getId() == id).findFirst();
        return first;
    }


    @PutMapping("/api/v1/employee/{id}")
    public String updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        Optional<Book> first = bookStore.bookList.stream().
                filter(book1 -> book1.getId() == id).findFirst();
        if (first.isPresent()) {
            first.get().setId(book.getId());
            first.get().setTitle(book.getTitle());
            first.get().setAuthors(book.getAuthors());
            first.get().setDescription(book.getDescription());
            first.get().setStatus(book.getStatus());
            first.get().setTags(book.getTags());
            return "Book updated";
        } else {
            return "Book not found";
        }
    }

    @GetMapping("/api/v1/employee")
    public Optional<Book> findBookById3(@CookieValue("id") int id) {
        System.out.println("findBookById3"+"@CookieValue");
        Optional<Book> first = bookStore.bookList.stream().
                filter(book -> book.getId() == id).findFirst();
        return first;
    }


    @GetMapping(value = "/api/v1/employee/ID")
    public Optional<Book> findBookById4(@RequestHeader("ID") int id) {
        System.out.println("findBookById4"+"@RequestHeader");
        Optional<Book> first = bookStore.bookList.stream().
                filter(book -> book.getId() == id).findFirst();
        return first;
    }

}
