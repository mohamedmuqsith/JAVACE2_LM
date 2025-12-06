package com.library.command;

import java.util.ArrayList;
import java.util.List;

/**
 * COMMAND PATTERN - Command invoker to execute and manage commands
 * Student ID: KU00298794
 */
public class KU00298794_CommandInvoker {
    private List<KU00298794_Command> commandHistory;

    public KU00298794_CommandInvoker() {
        this.commandHistory = new ArrayList<>();
    }

    public boolean executeCommand(KU00298794_Command command) {
        boolean result = command.execute();
        if (result) {
            commandHistory.add(command);
            System.out.println("[COMMAND LOGGED] " + command.getDescription());
        }
        return result;
    }

    public boolean undoLastCommand() {
        if (commandHistory.isEmpty()) {
            System.out.println("[UNDO FAILED] No commands to undo.");
            return false;
        }

        KU00298794_Command lastCommand = commandHistory.remove(commandHistory.size() - 1);
        boolean result = lastCommand.undo();

        if (result) {
            System.out.println("[UNDO SUCCESS] " + lastCommand.getDescription());
        } else {
            System.out.println("[UNDO FAILED] Could not undo: " + lastCommand.getDescription());
        }

        return result;
    }

    public List<KU00298794_Command> getHistory() {
        return new ArrayList<>(commandHistory);
    }

    public void printHistory() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                      COMMAND HISTORY                           ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");

        if (commandHistory.isEmpty()) {
            System.out.println("  No commands executed yet.");
        } else {
            for (int i = 0; i < commandHistory.size(); i++) {
                System.out.printf("  %d. %s\n", i + 1, commandHistory.get(i).getDescription());
            }
        }
        System.out.println();
    }
}
