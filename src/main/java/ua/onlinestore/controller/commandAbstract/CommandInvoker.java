package ua.onlinestore.controller.commandAbstract;

import java.util.EnumMap;

/**
 * Created by Владислав on 17.11.2017.
 */
public class CommandInvoker {
    private EnumMap<CommandEnum, Command> commands = new EnumMap<>(CommandEnum.class);

    public CommandInvoker() {
        commands.put(null,null);
    }

    public Command getCommand(String nameCommand) {
        CommandEnum currentCommand;
        currentCommand = CommandEnum.valueOf(nameCommand);
        return commands.get(currentCommand);
    }
}
