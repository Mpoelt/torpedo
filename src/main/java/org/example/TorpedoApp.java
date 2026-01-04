
package org.example;

import java.util.Scanner;

import org.example.display.MapDisplayer;
import org.example.domain.GameMap;
import org.example.domain.Player;
import org.example.domain.TorpedoGame;
import org.example.init.MapInit;
import org.example.init.PlayerInit;
import org.example.service.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TorpedoApp {
    public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       final ConsoleService consoleService = new ConsoleService(scanner);
       final MapInitDeciderService mapInitDecider = new MapInitDeciderService(consoleService);
       final MapInit mapInit = mapInitDecider.gatMapInitInstance();
       final PlayerInit playerInit = new PlayerInit(consoleService);

       final GameMap gameMap = mapInit.readMapDetails();
       final Player player = playerInit.readPlayerDetails();
       final GameEndStateDeciderService deciderService = new GameEndStateDeciderService();
       final MapDisplayer mapDisplayer = new MapDisplayer(consoleService);
       final RocketLauncherService rocketLauncherService = new RocketLauncherService(consoleService);
       final GameService gameService = new GameService(deciderService, mapDisplayer, rocketLauncherService, consoleService);

       gameService.startGame(new TorpedoGame(gameMap, player));


    }
}
