package ru.itis.repositories;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    void save(T entity) throws SQLException;
    List<T> findAll();
    Optional<T> findById(T login);
}
