package ru.kpfu.itis.ConsoleWork;

import java.util.Arrays;
import java.util.Scanner;

public class App extends AbstractApplication {

    public static void main(String[] args) {
        try {
            App app = new App();
            app.init();
            app.start();
        } catch (Exception ex) {
            System.err.println("Program has been crashed: " + ex.getMessage());
        }
    }

    private String[] commandNames;
    private Command[] commands;
    private final int INIT_SIZE = 100;
    private String[] notes;
    private int notesCount;
    private Scanner sc;


    @Override
    public void init(){
        notes = new String[INIT_SIZE];
        sc = new Scanner(System.in);
        commandNames = new String[]{"add", "readAll", "exit"};
        commands = new Command[]{
                new AddCommand(this),
                new ReadAllCommand(this),
                new ExitCommand()
        };
    }

    @Override
    public void start(){
        while (true) {
            String userCommand = sc.nextLine();
            int commandIndex = 0;
            boolean found = false;
            for (String commandName : commandNames) {
                if (userCommand.equals(commandName)) {
                    commands[commandIndex].execute();
                    found = true;
                    break;
                }
                commandIndex++;
            }
            if (!found) {
                System.out.println("Command not found");
            }

        }
    }

    public String[] getNotes() {
        return Arrays.copyOf(notes, notes.length);
    }
    public void addNote(String note) {
        notes[notesCount] = note;
        notesCount++;
    }
    public Scanner getScanner() {
        return sc;
    }
    public void plusNotesCount() {
        notesCount++;
    }


}
