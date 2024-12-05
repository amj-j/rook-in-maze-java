package controller;

import interfaces.controller.ControllerInterface;
import interfaces.listeners.MenuListener;
import interfaces.model.ModelInterface;
import structures.MazeSize;

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

    public void changeMazeSize(MazeSize newSize) {
        controller.getModel().setMazeSize(newSize);
        controller.initNewGame();
    }
}
