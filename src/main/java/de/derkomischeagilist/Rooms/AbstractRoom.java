package de.derkomischeagilist.Rooms;

public abstract class AbstractRoom implements Room {
    @Override
    public String handleCommand(String command) {
        return String.format("Did you just ask me to '%s'?" +
                "<br /><br />" +
                "404 - command not found. Please enter 'help' to get a list of available commands.", command);
    }
}