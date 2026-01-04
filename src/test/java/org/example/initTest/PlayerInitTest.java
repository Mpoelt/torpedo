package org.example.initTest;

import org.example.domain.Player;
import org.example.init.PlayerInit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerInitTest {

    @Mock
    private Scanner scannerMock;

    private PlayerInit underTest;

    @BeforeEach
    public void setUp(){
    underTest = new PlayerInit(scannerMock);
    }

    @Test
    public void readPlayerDetailsReturnsPlayerWithNameFromScanner(){
        //GIVEN
        when(scannerMock.next()).thenReturn("Peter");
        //WHEN
        Player player = underTest.readPlayerDetails();
        //THEN
        assertEquals("Peter", player.getName());
        verify(scannerMock).next();


    }




}
