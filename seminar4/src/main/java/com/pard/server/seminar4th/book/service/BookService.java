package com.pard.server.seminar4th.book.service;


import com.pard.server.seminar4th.book.dto.BookRequest;
import com.pard.server.seminar4th.book.dto.BookResponse;
import com.pard.server.seminar4th.book.entity.Book;
import com.pard.server.seminar4th.book.repo.BookRepo;
import com.pard.server.seminar4th.user.entity.User;
import com.pard.server.seminar4th.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class BookService {
    private final UserRepo userRepo;
    private final BookRepo bookRepo;

    public void createBook(Long userId, BookRequest.BookCreateRequest req) {
        Optional<User> u = userRepo.findById(userId);
        User user = u.get();
        Book book = Book.from(req.getTitle(), user);
        bookRepo.save(book);
    }

    public BookResponse.BookReadResponse readBook(Long bookId) {
        Optional<Book> b = bookRepo.findById(bookId);
        Book book = b.get();
        return new BookResponse.BookReadResponse(bookId, book.getTitle());
    }


}
