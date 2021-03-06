package ua.goit.commands;

import ua.goit.commands.specialCommands.SpecialCommands;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandHandler {

    Map<String, Command> commandMap = new HashMap<>();

    public CommandHandler() {
        commandMap.put("developers", new CommandDev());
        commandMap.put("special", new SpecialCommands());
        commandMap.put("customers", new CommandCustomer());
        commandMap.put("projects", new CommandProject());
    }

    public void handleCommand(String params) throws SQLException {

        int i = params.indexOf(" ");
        if (i > -1) {
            Command command = commandMap.get(params.substring(0, i));
            if (command !=null){
                command.handle(params.substring(i + 1));
            } else{
                System.out.println("Unknown command");
            }
        }
    }
}
