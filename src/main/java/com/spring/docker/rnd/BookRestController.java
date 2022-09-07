package com.spring.docker.rnd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;
    private static final Logger logger = LoggerFactory.getLogger(BookRestController.class);


    @RequestMapping(value = "/book/create", method = RequestMethod.POST)
    public String create(Book book) {
        logger.info("Request received to create book [{}]", book);
        bookRepository.save(book);
        return "Book Created";
    }

    @RequestMapping(value = "/book/print/{name}", method = RequestMethod.POST)
    public List<Book> print(@PathVariable("name") String name) {
        logger.info("Request received to print book [{}]", name);
        final List<Book> list = bookRepository.findByName(name);
        return list;


    }
}
