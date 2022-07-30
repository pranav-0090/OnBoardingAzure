package com.prank.spring.jpa.hibernate.controller;

import com.prank.spring.jpa.hibernate.models.BookInfo;
import com.prank.spring.jpa.hibernate.requests.CreateBookRequest;
import com.prank.spring.jpa.hibernate.service.BookService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Log4j2
public class BookController {

    /* View -> Controller -> Service -> CreateUserRequest(Creating UserInfo)
     *  -> UserRepository(Saving UserInfo)
     */

    @Autowired
    BookService bookService;

    @GetMapping("/testbook")
    public String getAllBooks(){
        log.info("BookController-----getAllUsers  Hello Moto: ");

        CreateBookRequest book = new CreateBookRequest();
        book.setName("test");
        book.setAuthor("test author");
        book.setCost(400);

        bookService.createBook(book);
        return "Hello test Moto";
    }

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE) //consumes not working here
    public ResponseEntity<List<BookInfo>> getAllBooksInfo(){
        log.info("BookController-------> getAllBooksInfo");
        ResponseEntity<List<BookInfo>> res =  new ResponseEntity<List<BookInfo>>(bookService.getAllBooksInfo(), HttpStatus.OK);
        return res;
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<Optional<BookInfo>> getOneBookById(@RequestParam(name = "bookId", defaultValue= "0") Integer id){
        log.info("BookController-------> getOneBookById");
        ResponseEntity<Optional<BookInfo>> res =  new ResponseEntity<Optional<BookInfo>>(bookService.getOneBookById(id), HttpStatus.OK);
        return res;
    }

    //ResponseEntity is a wraparound to provide status code also
    @PostMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookInfo> createABook(@Valid @RequestBody CreateBookRequest book){
        log.info("BookController-------> create user request received user: "+book.getName());
        return new ResponseEntity<BookInfo>(bookService.createBook(book), HttpStatus.ACCEPTED);
    }
}
