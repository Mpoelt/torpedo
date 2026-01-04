package org.example.displayTest;


import org.example.display.MapDisplayer;
import org.example.domain.Ship;

import org.example.domain.GameMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MapDisplayerTest {

    @Mock
    private GameMap gameMapMock;

    @Mock
    private Ship shipMock;

    @InjectMocks
    private MapDisplayer mapDisplayer;


    @Test
    void displayMap_CallsGameMethods(){
        //GIVEN
        when(gameMapMock.getSize()).thenReturn(5);
        when(gameMapMock.getShip()).thenReturn(shipMock);

        //WHEN
        mapDisplayer.displayMap(gameMapMock);
        //THEN
        verify(gameMapMock).getSize();
        verify(gameMapMock).getShip();

    }





}
