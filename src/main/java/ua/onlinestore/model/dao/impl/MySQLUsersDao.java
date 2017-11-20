package ua.onlinestore.model.dao.impl;

import ua.onlinestore.model.dao.exceptions.PersistException;
import ua.onlinestore.model.dao.intefaces.AbstractJDBCDao;
import ua.onlinestore.model.dao.intefaces.UsersDao;
import ua.onlinestore.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Владислав on 20.11.2017.
 */
public class MySQLUsersDao extends AbstractJDBCDao<User,Integer>{
    private Connection connection;

    public MySQLUsersDao(Connection connection) {
        super(connection);
    }


    /*
     метод setId доступным только для Dao объекта
     */
    public class PersistUser extends User{
            public void setId(int id){
              super.setId(id);
            }
    }
    @Override
    public String getSelectQuery() {
        return null;
    }

    @Override
    public String getCreateQuery() {
        return null;
    }

    @Override
    public String getUpdateQuery() {
        return null;
    }

    @Override
    public String getDeleteQuery() {
        return null;
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<User> list = new LinkedList<>();
        try{
            while (rs.next()){
            PersistUser user = new PersistUser();
             user.setId(rs.getInt("id"));
             user.setNickname(rs.getString("nickname"));
             user.setPassword(rs.getString("password"));
             user.setEmail(rs.getString("email"));
             user.setRole(rs.getBoolean("role"));
             user.setDefaulter(rs.getBoolean("id_defaulter"));
             list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws PersistException {

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws PersistException {

    }
}
