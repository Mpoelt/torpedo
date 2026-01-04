package org.example.domain;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data

public class GameMap {

    private final int size;
    private final Ship ship;
    private final Set<RocketDestination> missedRocketDestinations;

    public Set<RocketDestination> getMissedRocketDestinations() {
        return missedRocketDestinations;
    }

    public GameMap(final int size, Ship ship) {
        this.size = size;
        this.ship = ship;
        this.missedRocketDestinations = new HashSet<>();
    }


}
