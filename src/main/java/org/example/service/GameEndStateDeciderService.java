package org.example.service;

import org.example.domain.Ship;
import org.springframework.stereotype.Service;

@Service
public class GameEndStateDeciderService {
    public boolean isFinished(final Ship ship) {
     boolean isFinished = true;

     for (boolean hit : ship.getHits()) {
         if (!hit) {
             isFinished = false;
             break;
         }
     }
     return isFinished;
    }

}
