package com.prank.spring.jpa.hibernate.service;

import com.prank.spring.jpa.hibernate.Repository.BookRepository;
import com.prank.spring.jpa.hibernate.models.BookInfo;
import com.prank.spring.jpa.hibernate.requests.CreateBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepo;

    public BookInfo createBook(@Valid CreateBookRequest bookRequest){

        //Convert bookRequest(without id) to BookInfo(with id auto incremented from db)
        BookInfo book = bookRequest.toBook();
        bookRepo.save(book); //save takes BookInfo annotated with @Entity as input

        return book;
    }

    public List<BookInfo> getAllBooksInfo(){
        return bookRepo.findAll();
    }

    public Optional<BookInfo> getOneBookById(Integer id){
        return bookRepo.findById(id);
    }
}
