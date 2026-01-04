package org.example.init;

import org.example.domain.GameMap;
import org.example.domain.Ship;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class FileMapInit implements MapInit {
    private final static String FILE_NAME = "map.txt";


    @Override
    public GameMap readMapDetails() {
        GameMap gameMap;
        try{
            final List<String>lines = Files.readAllLines(Paths.get(ClassLoader.getSystemResource(FILE_NAME).toURI()));
            final int mapSize = Integer.parseInt(lines.get(0));
            final int shipSize = Integer.parseInt(lines.get(1));
            final int shipStartRow = Integer.parseInt(lines.get(2));
            final int shipStartCol = Integer.parseInt(lines.get(3));
            final boolean isShipHorizontal = Boolean.parseBoolean(lines.get(4));
            final Ship ship = new Ship(shipSize, shipStartRow, shipStartCol, isShipHorizontal);
            gameMap = new GameMap(mapSize, ship);


        } catch (Exception e) {
            throw new RuntimeException("Error during reading  the file");
        }
        return gameMap;
    }
}
