package com.example.demo3.service;

import com.example.demo3.entity.Author;
import com.example.demo3.entity.Book;
import com.example.demo3.entity.Catalogue;
import com.example.demo3.entity.Publisher;
import com.example.demo3.exception.ResourceExeptionNotFound;
import com.example.demo3.repository.AuthorRepository;
import com.example.demo3.repository.BookRepository;
import com.example.demo3.repository.CatalogueRepository;
import com.example.demo3.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.RejectedExecutionException;

@Service
public class BookService {

    private BookRepository bookRepository;
    private CatalogueRepository catalogueRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public BookService(BookRepository bookRepository, CatalogueRepository catalogueRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.catalogueRepository = catalogueRepository;
        this.publisherRepository = publisherRepository;
    }

    public Page<Book> getAll(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }

    public Page<Book> getByCatalogue(Integer catalogue_id, Pageable pageable) throws ResourceExeptionNotFound {
        Catalogue catalogue = this.catalogueRepository.findById(catalogue_id).orElseThrow(() -> new ResourceExeptionNotFound("Not found this catalogue" + catalogue_id));
        return this.bookRepository.findBooksByCatalogue(catalogue, pageable);
    }

    public Page<Book> getByAuthor(Integer id, Pageable pageable) throws ResourceExeptionNotFound {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new ResourceExeptionNotFound("Not found this author"));
        return this.bookRepository.findBooksByAuthor(author, pageable);
    }

    public Page<Book> getByPublisher(Integer publisher_id, Pageable pageable) throws ResourceExeptionNotFound {
        Publisher publisher = this.publisherRepository.findById(publisher_id).orElseThrow(() -> new ResourceExeptionNotFound("Not found this publisher"));
        return this.bookRepository.findBooksByPublisher(publisher, pageable);
    }

    public Optional<Book> findOne(int id) {
        return this.bookRepository.findById(id);
    }
    public Book findOneBook(int id) throws ResourceExeptionNotFound {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new ResourceExeptionNotFound("Not found this post" + id));
        return book;
    }


    public void Save(Book book) {
        this.bookRepository.save(book);
    }

    public Book SaveBook(Book book) {
        return this.bookRepository.save(book);
    }

    public Map<String, Boolean> deleteBook(Integer id) throws ResourceExeptionNotFound {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new ResourceExeptionNotFound("Not found this post" + id));
        this.bookRepository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return response;
    }

    public Page<Book> searchBook(String keyword, Pageable pageable) {
        return this.bookRepository.findBookByTitleContaining(keyword, pageable);
    }

}
