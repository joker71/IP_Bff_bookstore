package com.example.demo3.controller;

import com.example.demo3.config.BaseResponse;
import com.example.demo3.entity.Author;
import com.example.demo3.entity.Book;
import com.example.demo3.entity.Stock;
import com.example.demo3.exception.ResourceExeptionNotFound;
import com.example.demo3.service.BookService;
import com.example.demo3.service.FirebaseImageService;
import com.example.demo3.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private StockService stockService;

    @Autowired
    private FirebaseImageService imageService;

    @GetMapping("/get")
    public Page<Book> getAll(Pageable pageable) {
        return this.bookService.getAll(pageable);
    }


    @GetMapping("/get/{id}")
    public Optional<Book> getById(@PathVariable Integer id) {
        return this.bookService.findOne(id);
    }

    @GetMapping("/catalogue/{id}")
    public Page<Book> getByCatalogue(@PathVariable Integer id, Pageable pageable) throws ResourceExeptionNotFound {
        return this.bookService.getByCatalogue(id, pageable);
    }

    @GetMapping("/author/{id}")
    public Page<Book> getByAuthor(@PathVariable Integer id, Pageable pageable) throws ResourceExeptionNotFound {
        return this.bookService.getByAuthor(id, pageable);
    }

    @GetMapping("/publisher/{id}")
    public Page<Book> getByPublisher(@PathVariable Integer id, Pageable pageable) throws ResourceExeptionNotFound {
        return this.bookService.getByPublisher(id, pageable);
    }

    @GetMapping("/stock")
    public Page<Stock> getStocks(Pageable pageable){
        return this.stockService.getAll(pageable);
    }

    @GetMapping("/stock/{id}")
    public List<Stock> getStockHistory(@PathVariable Integer id) {
        return this.stockService.getByProduct(id);
    }
    @PostMapping("/stock/post")
    public HttpStatus postStock(@RequestBody Stock stock){
        this.stockService.save(stock);
        return HttpStatus.CREATED;
    }
    @PostMapping("/post")
    public HttpStatus postBook(@RequestBody Book book) {
        Book savedBook = this.bookService.SaveBook(book);
        Integer num_item = savedBook.getStock();
        Integer price = savedBook.getPrice();
        Stock stock = new Stock(0, savedBook.getBook_id(), savedBook.getStock(), new Date(), price * num_item);
        stockService.save(stock);
        return HttpStatus.CREATED;
    }

    @PutMapping("/put")
    public BaseResponse<Book> putBook(@RequestBody Book book) throws ResourceExeptionNotFound {
        Integer id = book.getBook_id();
        Optional<Book> data = this.bookService.findOne(id);
        if (!data.isPresent()) {
            return new BaseResponse<Book>(false, Arrays.asList("Tac gia không tồn tại"), 400, null);
        } else {
            this.bookService.Save(book);
            return new BaseResponse<Book>(true, Arrays.asList("Cap nhat thong tin thanh cong"), 200, null);
        }
    }

    @PutMapping("/delete/{id}")
    public Book deleteBook(@PathVariable int id) throws ResourceExeptionNotFound {
        return this.bookService.setDeleteFlag(id);
    }

    @GetMapping("/search")
    public Page<Book> searchBook(@RequestHeader("key") String keyword, Pageable pageable) {
        System.out.print(keyword);
        return this.bookService.searchBook(keyword, pageable);
    }


}
