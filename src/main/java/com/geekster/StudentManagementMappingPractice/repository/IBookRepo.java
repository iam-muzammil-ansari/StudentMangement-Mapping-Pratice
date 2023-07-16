package com.geekster.StudentManagementMappingPractice.repository;

import com.geekster.StudentManagementMappingPractice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepo extends JpaRepository<Book, Integer> {
    List<Book> findByBookAuthor(String bookAuthor);

    @Modifying
    @Query(value = "update book set book_price = :price where book_author = :bookAuthor", nativeQuery = true)
    Integer updateBookInfoByBookAuthor(String bookAuthor, Integer price);

    @Modifying
    @Query(value = "Delete from book where book_author = :bookAuthor", nativeQuery = true)
    Integer removeAllBooksByBookAuthor(String bookAuthor);
}