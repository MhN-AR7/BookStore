package ir.maktabsharif.repository;

import ir.maktabsharif.exception.DatabaseQueryException;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.util.DatabaseConfig;

import java.sql.*;

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
