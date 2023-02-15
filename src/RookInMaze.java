import model.MazeCreator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import model.DefaultValues;
import view.MazeView;
import structures.*;

public class RookInMaze {
    public static void main(String[] args) {
        MazeCreator creator = new MazeCreator();
        MazeView view = new MazeView();
        JFrame frame = new JFrame();

        frame.setSize(new Dimension(700, 500));
        view.setMazeInfo(creator.createMaze(DefaultValues.MAZE_WIDTH, DefaultValues.MAZE_HEIGHT));
        view.setFinishPos(new TileCoords(0,0));
        view.setPlayerPos(new TileCoords(1,1));
        frame.add(view);
        frame.setVisible(true);
    }
}
