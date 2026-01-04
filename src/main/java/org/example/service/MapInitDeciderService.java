package org.example.service;

import org.example.init.ConsoleMapInit;
import org.example.init.FileMapInit;
import org.example.init.MapInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class MapInitDeciderService {

    @Autowired
    private ConsoleService consoleService;

    public MapInit gatMapInitInstance(ApplicationContext context){
        int option = consoleService.readIntFromConsole("Please provide number '1' for manual setup or '2' for loading from a file");

        return switch (option){
            case 1 -> context.getBean(ConsoleMapInit.class);
            case 2 -> context.getBean(FileMapInit.class);
            default -> null;
        };
    }
}
