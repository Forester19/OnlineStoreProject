package ua.onlinestore.controller;

import ua.onlinestore.controller.commandAbstract.Command;
import ua.onlinestore.controller.commandAbstract.CommandInvoker;
import ua.onlinestore.model.ResourceManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Владислав on 17.11.2017.
 */
@WebServlet(name = "default servlet", urlPatterns = {"/rulang"})
public class DefaultServlet extends HttpServlet {
    private ResourceManager resourceManager = ResourceManager.INSTANCE;
    private final static String COMMAND_STRING =  "command";

    private CommandInvoker commandProvider = new CommandInvoker();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter(COMMAND_STRING);
        if (commandName == null) {
            commandName = (String) req.getAttribute(COMMAND_STRING);
            }
        Command commandOriginal = commandProvider.getCommand(commandName);
        commandOriginal.execute(req, resp);
    }
}
