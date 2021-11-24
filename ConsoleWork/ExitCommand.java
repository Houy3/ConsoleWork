package ru.kpfu.itis.ConsoleWork;

public class ExitCommand implements Command {
    public Object execute() {
        System.exit(0);
        return null;
    }
}
