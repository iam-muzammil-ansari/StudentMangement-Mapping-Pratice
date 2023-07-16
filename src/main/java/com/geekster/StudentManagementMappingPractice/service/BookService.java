package com.geekster.StudentManagementMappingPractice.service;

import com.geekster.StudentManagementMappingPractice.model.Book;
import java.util.List;
import com.geekster.StudentManagementMappingPractice.repository.IBookRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    IBookRepo iBookRepo;

    public String addBook(Book book) {
        iBookRepo.save(book);
        return "Book Added Successfully!!!";
    }

    public List<Book> getAllBooksByBookAuthor(String bookAuthor) {
        return iBookRepo.findByBookAuthor(bookAuthor);
    }

    @Transactional
    public String updateBookInfoByBookAuthor(String bookAuthor, Integer price) {
        Integer countUpdate = iBookRepo.updateBookInfoByBookAuthor(bookAuthor, price);
        if(countUpdate > 0) {
            return "Book Information updated Successfully!!";
        }else {
            return "Book information not updated because this Book author does not exist";
        }
    }

    @Transactional
    public String removeAllBooksByBookAuthor(String bookAuthor) {
        Integer countDelete = iBookRepo.removeAllBooksByBookAuthor(bookAuthor);
        if(countDelete > 0) {
            return "Laptop Deleted Successfully!!";
        }else {
            return "Laptop not deleted because this Brand does not exist";
        }
    }
}