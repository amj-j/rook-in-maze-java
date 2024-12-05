package interfaces.controller;

import interfaces.model.ModelInterface;
import interfaces.view.*;;

public interface ControllerInterface {
    public ModelInterface getModel();
    public ViewInterface getView();
    public MazeView getMazeView();
    public MenuView getMenuView();
    public void initNewGame();
}
