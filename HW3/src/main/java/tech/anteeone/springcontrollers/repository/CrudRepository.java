package tech.anteeone.springcontrollers.repository;

import java.util.List;

public interface CrudRepository<T> {

    void create(T entity);
    void read(T entity);
    List<T> readAll();
    void update(T entity);
    void delete(T entity);
}
