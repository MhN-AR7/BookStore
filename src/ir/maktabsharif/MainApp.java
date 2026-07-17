package ir.maktabsharif;

import ir.maktabsharif.model.Book;
import ir.maktabsharif.repository.BookRepository;

import java.util.Set;

public class MainApp {
    static void main() {
//        Book book1 = new Book("Java", "Najafi", 500.5);
//        book1.setId(1);
//        Book book2 = new Book("Java", "Najafi", 500.5);
//        book2.setId(1);
//
//        Set<Book> books = Set.of(book1, book2);
//
//        System.out.println(books.size());

        BookRepository bookRepository = new BookRepository();

//        bookRepository.create(new Book("Java", "Najafi", 500.5));
//        bookRepository.create(new Book("Python", "Najafi", 600));
//        bookRepository.create(new Book("C++", "Najafi", 400));

        bookRepository.findAll().forEach(System.out::println);
    }
}
