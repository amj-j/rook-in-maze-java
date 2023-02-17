package controller;

import interfaces.listeners.MenuListener;
import interfaces.modelInterfaces.ModelInterface;
import interfaces.controllerInterfaces.ControllerInterface;

public class MenuController implements MenuListener {
    ControllerInterface controller;

    public MenuController(ControllerInterface controller) {
        this.controller = controller;
    }

    public void reset() {
        ModelInterface model = controller.getModel();
        model.resetWonGames();
        controller.initNewGame();
        controller.getMenuView().setWonGames(model.getWonGames());
    }

    public void changeMazeSize() {

    }
}
