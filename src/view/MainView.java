package view;

import java.awt.*;
import javax.swing.*;

public class MainView extends JFrame {
    MazeView maze;
    JPanel stats;
    JPanel menu;

    public MainView() {
        setSize(new Dimension(DefaultSettings.MAIN_WINDOW_WIDTH, DefaultSettings.MAIN_WINDOW_HEIGHT));
        maze = new MazeView();
    }
}
