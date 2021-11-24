package ru.kpfu.itis.ConsoleWork;

import java.util.Scanner;

public class AddCommand implements Command {
    private final App app;
    public AddCommand(App app) {
        this.app = app;
    }
    @Override
    public Object execute() {
        System.out.print("Note: ");
        String note = app.getScanner().nextLine();
        app.addNote(note);
        app.plusNotesCount();
        return null;
    }
}
