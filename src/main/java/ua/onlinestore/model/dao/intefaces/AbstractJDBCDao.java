package ua.onlinestore.model.dao.intefaces;

import ua.onlinestore.model.dao.exceptions.PersistException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Владислав on 20.11.2017.
 */
public abstract class AbstractJDBCDao<T, PK extends Integer> implements GenericDAO<T,PK> {
    private Connection connection;

    public AbstractJDBCDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * Возвращает sql запрос для получения всех записей.
     * <p/>
     * SELECT * FROM [Table]
     */
    public abstract String getSelectQuery();

    /**
     * Возвращает sql запрос для вставки новой записи в базу данных.
     * <p/>
     * INSERT INTO [Table] ([column, column, ...]) VALUES (?, ?, ...);
     */
    public abstract String getCreateQuery();

    /**
     * Возвращает sql запрос для обновления записи.
     * <p/>
     * UPDATE [Table] SET [column = ?, column = ?, ...] WHERE id = ?;
     */
    public abstract String getUpdateQuery();

    /**
     * Возвращает sql запрос для удаления записи из базы данных.
     * <p/>
     * DELETE FROM [Table] WHERE id= ?;
     */
    public abstract String getDeleteQuery();

    protected abstract List<T> parseResultSet(ResultSet rs) throws PersistException;

    /**
     * Устанавливает аргументы insert запроса в соответствии со значением полей объекта object.
     */
    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws PersistException;

    /**
     * Устанавливает аргументы update запроса в соответствии со значением полей объекта object.
     */
    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws PersistException;


    @Override
    public T create() {
        return null;
    }

    @Override
    public T persist(T t) {
        return null;
    }

    @Override
    public T getByPK(int pk) throws PersistException {
    List<T> list = null;
    String sql = getSelectQuery();
    sql += " where id = ?";
    try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
    preparedStatement.setInt(1,pk);
    ResultSet resultSet = preparedStatement.executeQuery();
    list = parseResultSet(resultSet);
    } catch (SQLException | PersistException e) {
        e.printStackTrace();
    }
    if (list==null||list.size()==0){
        return null;
    }
    if (list.size() > 1){
        throw new PersistException("Received more than one record.");
    }
        return list.iterator().next();
    }

    @Override
    public void update(T t) {

    }

    @Override
    public void delete(T t) {

    }

    @Override
    public List<T> getAll() {
        List<T> list = null;
        String sql = getSelectQuery();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            list = parseResultSet(resultSet);
        } catch (SQLException | PersistException e) {
            e.printStackTrace();
        }
        return list;
    }
}
