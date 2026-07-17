package ir.maktabsharif.repository;

import ir.maktabsharif.model.Book;
import ir.maktabsharif.util.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookRepository {

    public int create(Book book) {
        try (
                Connection connection = DatabaseConfig.getConnection();
                PreparedStatement ps = connection.prepareStatement("INSERT INTO books (title, author, price) VALUES (?, ?, ?)")
        ) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
        }
        catch (SQLException e) {

        }
        return 0;
    }

    public Book read(int id) {
        return null;
    }

    public Book update(Book book) {
        return null;
    }

    public int delete(int id) {
        return 0;
    }
}
