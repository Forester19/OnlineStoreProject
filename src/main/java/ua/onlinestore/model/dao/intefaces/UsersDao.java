package ua.onlinestore.model.dao.intefaces;

import ua.onlinestore.model.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Владислав on 20.11.2017.
 */
public interface UsersDao {
    User create();
    User read(int key);
    void update();
    void delete();
    public List<User> getAll() throws SQLException;
}
