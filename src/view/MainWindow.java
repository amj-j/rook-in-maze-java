package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import interfaces.viewInterfaces.*;

public class MainWindow extends JFrame implements ViewInterface {
    MazePanel maze;
    MenuPanel menu;

    public MainWindow() {
        setSize(new Dimension(DefaultSettings.MAIN_WINDOW_WIDTH, DefaultSettings.MAIN_WINDOW_HEIGHT));
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        maze = new MazePanel();
        menu = new MenuPanel();
        add(menu);
        add(maze);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int windowWidth = getContentPane().getWidth();
                int windowHeight = getContentPane().getHeight();
                menu.setPreferredSize(new Dimension(windowWidth, windowHeight/8));
                maze.setPreferredSize(new Dimension(windowWidth, 7*(windowHeight/8)));
            }
        });
    }

    public MazeView getMazeView() {
        return this.maze;
    }

    public MenuView getMenuView() {
        return this.menu;
    }
}
