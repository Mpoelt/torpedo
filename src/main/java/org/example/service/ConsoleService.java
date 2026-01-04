package org.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class ConsoleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleService.class);
    private final Scanner scanner;

    public ConsoleService(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readIntFromConsole(String message){
        LOGGER.info(message);
        return scanner.nextInt();
    }
    public boolean readBooleanFromConsole(String message){
        LOGGER.info(message);
        return scanner.nextBoolean();
    }
    public String readStringFromConsole(String message){
        LOGGER.info(message);
        return scanner.next();
    }

    public void print(String message){
        LOGGER.info(message);
    }

    public void printWithPlayerName(String message, String playerName){
        LOGGER.info(message, playerName);
    }

}
