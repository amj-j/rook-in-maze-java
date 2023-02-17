package controller;

import interfaces.controllerInterfaces.ControllerInterface;
import interfaces.listeners.MazeListener;
import interfaces.modelInterfaces.ModelInterface;
import structures.*;

public class MazeController implements MazeListener {
    ControllerInterface controller;

    public MazeController(ControllerInterface controller) {
        this.controller = controller;
    }

    public void mazeClicked(TileCoords coords) {
        ModelInterface model = controller.getModel();
        TileCoords newPlayerPos = model.moveTo(coords);
        if (newPlayerPos != null) {
            controller.getMazeView().setPlayerPos(newPlayerPos);
        }
        if (model.hasWon()) {
            model.addWonGame();
            controller.initNewGame();
            controller.getMenuView().setWonGames(model.getWonGames());
        }
    }
}
