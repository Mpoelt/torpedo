package org.example.service;

import org.example.database.entity.HighScore;
import org.example.display.MapDisplayer;
import org.example.domain.*;
import org.springframework.stereotype.Service;

@Service
public class GameService {


    private final GameEndStateDeciderService deciderService;
    private final MapDisplayer mapDisplayer;
    private final RocketLauncherService rocketLauncherService;
    private final ConsoleService consoleService;
    private final HighScoreService highScoreService;

    public GameService(final GameEndStateDeciderService gameEndStateDeciderService, final MapDisplayer mapDisplayer,
                       final RocketLauncherService rocketLauncherService, final ConsoleService consoleService,
                       final HighScoreService highScoreService) {
        this.deciderService = gameEndStateDeciderService;
        this.mapDisplayer = mapDisplayer;
        this.rocketLauncherService = rocketLauncherService;
        this.consoleService = consoleService;
        this.highScoreService = highScoreService;
    }

    public void startGame(final TorpedoGame torpedoGame) {
        final Player player = torpedoGame.getPlayer();
        final GameMap gameMap = torpedoGame.getGameMap();
        final Ship ship = gameMap.getShip();
        //mentünk új játékost ha nem létezik
        final HighScore highScore = highScoreService.findByPlayerNameOrCreate(player.getName());
        consoleService.printWithPlayerName("Hi {}, the game has been started, this is yout map: ", player.getName());
        while (!deciderService.isFinished(ship)) {
            //Kérjük map-et
            mapDisplayer.displayMap(gameMap);
            //Kérjük a destiantion-t
            final RocketDestination rocketDestination = rocketLauncherService.getRocketDestination();
            //Lövünk
            final boolean isHit = rocketLauncherService.isRocketHit(gameMap,rocketDestination);
            if (isHit){
                consoleService.print("Hit!");
            } else {
                consoleService.print("Missed!");
            }
        }
        //felülírjuk a HighScore
        highScore.setGamesWon(highScore.getGamesWon() + 1);
        highScoreService.save(highScore);
        mapDisplayer.displayMap(gameMap);
        consoleService.printWithPlayerName("Congratulation {}, there is no more ship on the map", player.getName());
    }
}
