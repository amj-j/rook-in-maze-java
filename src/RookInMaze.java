import model.MazeCreator;
import view.MazeView;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import model.DefaultValues;

public class RookInMaze {
    public static void main(String[] args) {
        MazeCreator creator = new MazeCreator();
        MazeView can = new MazeView();
        JFrame frame = new JFrame();

        frame.setSize(new Dimension(500, 700));
        can.mazeInfo = creator.createMaze(DefaultValues.MAZE_WIDTH, DefaultValues.MAZE_HEIGHT);
        frame.add(can);
        frame.setVisible(true);
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                System.out.println("resized");
            }
        });
    }
}
