import model.Model;
import view.MainWindow;
import controller.Controller;

public class RookInMaze {
    public static void main(String[] args) {
        Model model = new Model();
        MainWindow view = new MainWindow();
        Controller controller = new Controller(model, view);
        controller.initListeners();
    }
}
