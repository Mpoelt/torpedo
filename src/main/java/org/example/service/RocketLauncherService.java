package org.example.service;

import org.example.domain.GameMap;
import org.example.domain.Ship;
import org.example.domain.RocketDestination;
import org.springframework.stereotype.Service;


@Service
public class RocketLauncherService {
    private  final ConsoleService consoleService;

    public RocketLauncherService(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    public RocketDestination getRocketDestination(){
        final int row = consoleService.readIntFromConsole("Please provide the rocket's destination row:");
        final int col = consoleService.readIntFromConsole("Please provide the rocket's destination collumn:");
        return new RocketDestination(row,col);
    }

    public boolean isRocketHit(final GameMap gameMap, final RocketDestination rocketDestination){
        boolean isHit;
        final Ship ship = gameMap.getShip();

        if(ship.isHorizontal()){
            isHit = checkHorizontalHit(ship, rocketDestination);
        }else{
            isHit = checkVerticalHit(ship, rocketDestination);
        }
        if(!isHit) {
            gameMap.getMissedRocketDestinations().add(rocketDestination);
        }

        return isHit;
    }

private boolean checkHorizontalHit(final Ship ship, final RocketDestination rocketDestination){
    if(ship.getStartRow() == rocketDestination.getRow()){
        for (int i = 0; i < ship.getLength(); i++){
            if(ship.getStartCol() + i == rocketDestination.getCol()){
                ship.getHits()[i] = true;
                return true;
            }
        }

    } else{
        return false;
    }
    return false;
}

private boolean checkVerticalHit(final Ship ship, final RocketDestination rocketDestination){
    if(ship.getStartCol() == rocketDestination.getCol()){
        for (int i = 0; i < ship.getLength(); i++){
            if(ship.getStartRow() + i == rocketDestination.getRow()){
                ship.getHits()[i] = true;
                return true;
            }
        }

    } else{
        return false;
    }
    return false;
}



}
