package com.example.demo3.repository;

import com.example.demo3.entity.Author;
import com.example.demo3.entity.Book;
import com.example.demo3.entity.Catalogue;
import com.example.demo3.entity.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT b FROM Book b WHERE b.catalogue = :catalogue ")
    Page<Book> findBooksByCatalogue(@Param("catalogue") Catalogue catalogue, Pageable pageable);

    @Query(value = "SELECT b FROM Book b WHERE b.author = :author ")
    Page<Book> findBooksByAuthor(@Param("author") Author author, Pageable pageable);

    @Query(value = "SELECT b FROM Book b WHERE b.publisher = :publisher ")
    Page<Book> findBooksByPublisher(@Param("publisher") Publisher publisher, Pageable pageable);

}
