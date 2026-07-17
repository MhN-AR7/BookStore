package ir.maktabsharif.repository;

import ir.maktabsharif.exception.BookNotFoundException;
import ir.maktabsharif.exception.DatabaseQueryException;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.util.DatabaseConfig;

import java.sql.*;
import java.util.Optional;

public class BookRepository {

    public int create(Book book) {
        try (
                Connection connection = DatabaseConfig.getConnection();
                PreparedStatement ps = connection.prepareStatement("INSERT INTO books (title, author, price) VALUES (?, ?, ?)"
                                                                    , Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) return rs.getInt("id");
            return 0;
        }
        catch (SQLException e) {
            throw new DatabaseQueryException("Insertion to Database Failed: " + e.getMessage());
        }
    }

    public Optional<Book> read(int id) throws BookNotFoundException {
        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM books WHERE id = ?"
            )
        ) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Book book = new Book(
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDouble(4)
                    );
                    book.setId(rs.getInt(1));
                    return Optional.of(book);
                }
                else throw new BookNotFoundException("Book Not Found With ID: " + id);
            }
        }
        catch (SQLException e) {
            throw new DatabaseQueryException("Read from Database Failed: " + e.getMessage());
        }
    }

    public Book update(Book book) {
        return null;
    }

    public int delete(int id) {
        return 0;
    }
}
