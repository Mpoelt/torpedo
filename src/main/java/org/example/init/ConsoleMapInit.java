package org.example.init;

import org.example.domain.Ship;
import org.example.domain.GameMap;
import org.example.service.ConsoleService;


public class ConsoleMapInit implements MapInit{
    private final ConsoleService consoleService;

    public ConsoleMapInit(final ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @Override
    public GameMap readMapDetails() {
        int mapSize = consoleService.readIntFromConsole("Please provide the map size: ");
        int shipSize = consoleService.readIntFromConsole("Please provide the ship size: ");
        int startRow = consoleService.readIntFromConsole("Please provide the ship's starting row: ");
        int startCol = consoleService.readIntFromConsole("Please provide the ship's column row: ");
        boolean isHorizontal = consoleService.readBooleanFromConsole("Please provide if the ship is horizontal (true/false)");


        final Ship ship = new Ship(shipSize, startRow, startCol, isHorizontal);
        return new GameMap(mapSize, ship);

    }


}
