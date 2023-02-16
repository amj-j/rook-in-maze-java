package controller;

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
}