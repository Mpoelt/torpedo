package org.example.domain;

import lombok.Data;

@Data
public final class TorpedoGame {
    private final GameMap gameMap;
    private final Player player;

    public TorpedoGame(final GameMap gameMap, Player player) {
        this.gameMap = gameMap;
        this.player = player;
    }

}
