package com.geekster.StudentManagementMappingPractice.controller;

import com.geekster.StudentManagementMappingPractice.model.Book;
import com.geekster.StudentManagementMappingPractice.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class BookController {
    @Autowired
    BookService bookService;

    //    Task -- 1 --> Adding Book --> Create --CR(Crud Repository)
    @PostMapping("book")
    public String addBook(@RequestBody @Valid Book book) {
        return bookService.addBook(book);
    }

    //    Task -- 2 --> Getting All Book --> READ/GET --CF(Custom Finder)
    @GetMapping("books")
    public List<Book> getBookByBookAuthor(@RequestParam String bookAuthor) {
        return bookService.getAllBooksByBookAuthor(bookAuthor);
    }

    //    Task -- 3 --> Update Book information by author --> Update --CQ(Custom Query)
    @PutMapping("book")
    public String updateBookInfoByBookAuthor(@RequestParam String bookAuthor, @RequestParam Integer price) {
        return bookService.updateBookInfoByBookAuthor(bookAuthor, price);
    }

    //    Task -- 4 --> delete all Book by Author --> Delete --CR(Custom Repository)
    @DeleteMapping("books")
    public String removeAllBooksByBookAuthor(@RequestParam String bookAuthor) {
        return bookService.removeAllBooksByBookAuthor(bookAuthor);
    }
}