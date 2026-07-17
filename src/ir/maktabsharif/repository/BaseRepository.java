package ir.maktabsharif.repository;

import ir.maktabsharif.exception.BookNotFoundException;
import ir.maktabsharif.exception.UserNotFoundException;
import ir.maktabsharif.model.BaseModel;

import java.util.Optional;
import java.util.Set;

public interface BaseRepository<ID, T extends BaseModel<ID>> {
    ID create(T t);
    Optional<T> read(ID id) throws BookNotFoundException, UserNotFoundException;
    T update(T t);
    ID delete(ID id);
    Set<T> findAll();
}
