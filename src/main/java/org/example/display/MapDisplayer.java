package org.example.display;

import org.example.domain.RocketDestination;
import org.example.domain.Ship;
import org.example.domain.GameMap;
import org.example.service.ConsoleService;

import java.util.Set;

public class MapDisplayer {

    private final ConsoleService consoleService;

    public MapDisplayer(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    public void displayMap(GameMap gameMap) {
        int size = gameMap.getSize();
        final Ship ship = gameMap.getShip();
        char[][] matrix = emptySetup(size);
        addShipHitsToDisplay(ship, matrix);
        addMissedDestinationToDisplay(matrix, gameMap.getMissedRocketDestinations());
        consoleService.print(getPrettyPrint(size, matrix));

    }

    private void addMissedDestinationToDisplay(final char[][] matrix, final Set<RocketDestination> missedDestinations) {
        for (RocketDestination rocketDestination : missedDestinations){
            matrix[rocketDestination.getRow()][rocketDestination.getCol()] = 'O';
        }
    }

    private String getPrettyPrint(int size, char[][]matrix) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                stringBuilder.append(matrix[row][col]).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private char[][] emptySetup(int mapSize) {
        char[][] matrix = new char[mapSize][mapSize];

        for (int row = 0; row < mapSize; row++) {
            for (int col = 0; col < mapSize; col++) {
                matrix[row][col] = '~';
            }
        }
        return matrix;
    }

    private void addShipHitsToDisplay(Ship ship, char[][] matrix) {
        for (int i = 0; i < ship.getLength(); i++) {
            int row = ship.getStartRow();
            int col = ship.getStartCol();

            if (ship.isHorizontal()) {
                col = col + i;
            } else {
                row = row + i;
            }
            if (ship.getHits()[i]) {
                matrix[row][col] = 'X';
            }
        }
    }


}
