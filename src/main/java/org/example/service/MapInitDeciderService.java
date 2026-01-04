package org.example.service;

import org.example.init.ConsoleMapInit;
import org.example.init.FileMapInit;
import org.example.init.MapInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapInitDeciderService {

    @Autowired
    private ConsoleService consoleService;

    public MapInitDeciderService(final ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    public MapInit gatMapInitInstance(){
        int option = consoleService.readIntFromConsole("Please provide number '1' for manual setup or '2' for loading from a file");

        return switch (option){
            case 1 -> new ConsoleMapInit(consoleService);
            case 2 -> new FileMapInit();
            default -> null;
        };
    }
}
