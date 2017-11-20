package ua.onlinestore.controller.commandAbstract;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Владислав on 17.11.2017.
 */
public interface Command {
    void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
