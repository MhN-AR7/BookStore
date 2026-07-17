package ir.maktabsharif.service;

import ir.maktabsharif.exception.BookNotFoundException;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.repository.BookRepository;

import java.util.Optional;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private void validator(String title, String author, double price) {
        if (title.length() < 3) throw new IllegalArgumentException("Book's title field must have at least 3 character!");
        if (author.length() < 3) throw new IllegalArgumentException("Book's author field must have at least 3 character!");
        if (price < 0) throw new IllegalArgumentException("Price value must be greater than 0!");
    }

    public void addBook(
            String title,
            String author,
            double price
    ) {
        validator(title, author, price);

        Book book = new Book(title, author, price);
        int generatedId = bookRepository.create(book);
        System.out.println("Book Created Successfully with ID: " + generatedId);
    }

    public Optional<Book> findById(int id) {
        try {
            return bookRepository.read(id);
        }
        catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }
}
