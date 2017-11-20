package ua.onlinestore.model.dao.exceptions;

/**
 * Created by Владислав on 20.11.2017.
 */
public class PersistException extends Exception {
    String messege;
    public PersistException(String s) {
        messege = s;
    }

    @Override
    public String getMessage() {
        return messege;
    }
}
