package ir.maktabsharif.repository;

import ir.maktabsharif.exception.BookNotFoundException;
import ir.maktabsharif.exception.DatabaseQueryException;
import ir.maktabsharif.exception.UserNotFoundException;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.model.User;
import ir.maktabsharif.util.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;

public class UserRepository implements BaseRepository<String, User>{
    @Override
    public String create(User user) {
        return "";
    }

    @Override
    public Optional<User> read(String s) throws UserNotFoundException {
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "SELECT * FROM users WHERE id = ?"
             )
        ) {
            ps.setString(1, s);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    return Optional.of(user);
                }
                else throw new UserNotFoundException("User Not Found With ID: " + s);
            }
        }
        catch (SQLException e) {
            throw new DatabaseQueryException("Read from Database Failed: " + e.getMessage());
        }
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public String delete(String s) {
        return "";
    }

    @Override
    public Set<User> findAll() {
        return Set.of();
    }
}
