package com.library.command;

/**
 * COMMAND PATTERN - Command interface for user actions
 * Student ID: KU00298794
 */
public interface KU00298794_Command {
    boolean execute();

    boolean undo();

    String getDescription();
}
