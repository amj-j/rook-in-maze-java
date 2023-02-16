package controller;

import interfaces.controllerInterfaces.ControllerInterface;
import interfaces.listeners.MazeListener;
import structures.*;

public class MazeController implements MazeListener {
    ControllerInterface controller;

    public MazeController(ControllerInterface controller) {
        this.controller = controller;
    }

    public void mazeClicked(TileCoords coords) {
        TileCoords newPlayerPos = controller.getModel().moveTo(coords);
        if (newPlayerPos != null) {
            controller.getMazeView().setPlayerPos(newPlayerPos);
        }
        if (controller.getModel().hasWon()) {
            
        }
    }
}
