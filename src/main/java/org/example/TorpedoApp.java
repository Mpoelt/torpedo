
package org.example;

import org.example.domain.GameMap;
import org.example.domain.Player;
import org.example.domain.TorpedoGame;
import org.example.init.MapInit;
import org.example.init.PlayerInit;
import org.example.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class TorpedoApp {
    public static void main(String[] args) {
       final ApplicationContext context = SpringApplication.run(TorpedoApp.class, args);
       final MapInit mapInit = context.getBean(MapInitDeciderService.class).gatMapInitInstance();
       final GameMap gameMap = mapInit.readMapDetails();
       final Player player = context.getBean(PlayerInit.class).readPlayerDetails();
       context.getBean(GameService.class).startGame(new TorpedoGame(gameMap, player));


    }
}
