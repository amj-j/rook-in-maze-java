package view;

import java.awt.*;
import javax.swing.*;

public class MainView extends JFrame {
    MazeView maze;
    MenuView menu;

    public MainView() {
        setSize(new Dimension(DefaultSettings.MAIN_WINDOW_WIDTH, DefaultSettings.MAIN_WINDOW_HEIGHT));
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        maze = new MazeView();
        menu = new MenuView();
        add(menu);
        add(maze);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
