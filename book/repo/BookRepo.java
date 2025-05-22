package com.pard.server.seminar4th.book.repo;


import com.pard.server.seminar4th.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {

}
