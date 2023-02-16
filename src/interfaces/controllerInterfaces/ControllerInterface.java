package interfaces.controllerInterfaces;

import interfaces.modelInterfaces.ModelInterface;
import interfaces.viewInterfaces.*;;

public interface ControllerInterface {
    public ModelInterface getModel();
    public ViewInterface getView();
    public MazeView getMazeView();
    public MenuView getMenuView();
}
