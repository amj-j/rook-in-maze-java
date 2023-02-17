package controller;

import interfaces.listeners.MenuListener;
import interfaces.controllerInterfaces.ControllerInterface;

public class MenuController implements MenuListener {
    ControllerInterface controller;

    public MenuController(ControllerInterface controller) {
        this.controller = controller;
    }

    public void reset() {
        
    }

    public void changeMazeSize() {

    }
}
