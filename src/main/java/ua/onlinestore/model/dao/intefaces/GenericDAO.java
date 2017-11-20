package ua.onlinestore.model.dao.intefaces;

import ua.onlinestore.model.dao.exceptions.PersistException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Владислав on 20.11.2017.
 */
public interface GenericDAO<T,PK> {
    T create();
    T persist(T t);
    T getByPK(int pk) throws PersistException;
    void update(T t);
    void delete(T t);
    List<T> getAll();

}
