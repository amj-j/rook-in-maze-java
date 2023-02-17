package controller;

import structures.*;
import interfaces.modelInterfaces.ModelInterface;
import interfaces.controllerInterfaces.ControllerInterface;
import interfaces.viewInterfaces.*;

public class Controller implements ControllerInterface {
    private ModelInterface model;
    private ViewInterface mainWindow;
    private MazeView mazeView;
    private MenuView menu;
    
    

    public ModelInterface getModel() {
        return this.model;
    }

    public ViewInterface getView() {
        return this.mainWindow;
    }

    public MazeView getMazeView() {
        return this.mazeView;
    }

    public MenuView getMenuView() {
        return this.menu;
    }

    public void initNewGame() {
        MazeInfo mazeInfo =  model.newMaze();
        TileCoords finishPos = model.setFinish(new TileCoords(mazeInfo.size.cols - 1, mazeInfo.size.rows - 1));
        TileCoords playerPos = model.initPlayer(new TileCoords(0, 0));
        mazeView.newMaze(mazeInfo);
        mazeView.setFinishPos(finishPos);
        mazeView.setPlayerPos(playerPos);
    }
}