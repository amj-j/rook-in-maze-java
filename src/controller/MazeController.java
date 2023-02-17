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
        TileCoords newPlayerPos = controller.getModel().moveTo(coords);
        handleAftermoveChanges(newPlayerPos);
    }

    public void leftPressed() {
        TileCoords newPlayerPos = controller.getModel().moveLeft();
        handleAftermoveChanges(newPlayerPos);
    }

    public void rightPressed() {
        TileCoords newPlayerPos = controller.getModel().moveRight();
        handleAftermoveChanges(newPlayerPos);
    }

    public void upPressed() {
        TileCoords newPlayerPos = controller.getModel().moveUp();
        handleAftermoveChanges(newPlayerPos);
    }

    public void downPressed() {
        TileCoords newPlayerPos = controller.getModel().moveDown();
        handleAftermoveChanges(newPlayerPos);
    }

    private void handleAftermoveChanges(TileCoords newPlayerPos) {
        ModelInterface model = controller.getModel();
        if (newPlayerPos != null) {
            controller.getMazeView().setPlayerPos(newPlayerPos);
            if (model.hasWon()) {
                controller.initNewGame();
                controller.getMenuView().setWonGames(model.getWonGames());
            }
        }
    }

}
