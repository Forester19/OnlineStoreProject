package ua.onlinestore.model.dao.intefaces;

import ua.onlinestore.model.entity.Product;
import ua.onlinestore.model.entity.User;

import java.util.List;

/**
 * Created by Владислав on 20.11.2017.
 */
public interface ProductsDao {

    Product create();
    Product read();
    void update();
    void delete();
    public List<Product> getAll();
}
