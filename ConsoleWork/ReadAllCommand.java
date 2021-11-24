package ru.kpfu.itis.ConsoleWork;

import java.util.Arrays;

public class ReadAllCommand implements Command {

    private final App app;
    public ReadAllCommand(App app) {
        this.app = app;
    }
    @Override
    public Object execute()  {
        System.out.print("All notes: ");
        System.out.println(Arrays.toString(app.getNotes()));
        return null;
    }
}
