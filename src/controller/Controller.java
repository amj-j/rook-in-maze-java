package controller;

import structures.*;
import interfaces.viewInterfaces.*;
import interfaces.controller.ControllerInterface;
import interfaces.listeners.*;
import interfaces.model.ModelInterface;

public class Controller implements ControllerInterface {
    private ModelInterface model;
    private ViewInterface view;

    private MazeView mazeView;
    private MenuView menuView;

    private MazeListener mazeListener;
    private MenuListener menuListener;
    
    public Controller(ModelInterface model, ViewInterface view) {
        this.model = model;
        this.view = view;
        this.mazeView = view.getMazeView();
        this.menuView = view.getMenuView();
        this.mazeListener = new MazeController(this);
        this.menuListener = new MenuController(this);
        mazeView.addListener(mazeListener);
        menuView.addListener(menuListener);
    }

    public ModelInterface getModel() {
        return this.model;
    }

    public ViewInterface getView() {
        return this.view;
    }

    public MazeView getMazeView() {
        return this.mazeView;
    }

    public MenuView getMenuView() {
        return this.menuView;
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