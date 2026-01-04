package org.example.init;

import org.example.domain.Player;
import org.example.service.ConsoleService;


public class PlayerInit {
    private final ConsoleService consoleService;

    public PlayerInit(final ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    public Player readPlayerDetails() {
        return new Player(consoleService.readStringFromConsole("Please provide your name: "));
    }
}
