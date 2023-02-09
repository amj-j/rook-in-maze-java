package view;

import java.awt.*;
import javax.swing.*;

import structures.MazeInfo;

public class MazeView extends Canvas {
    Graphics graphics;
    MazeInfo mazeInfo;

    private Color bgColor = DefaultSettings.MAZE_COLOR;
    private Color wallColor = DefaultSettings.WALL_COLOR;
    private Color playerColor = DefaultSettings.PLAYER_COLOR;
    
    @Override
    public void paint(Graphics g) {
        this.graphics = g;
    }

    private void drawWalls() {
        graphics.setColor(wallColor);
        
    }

    private void drawWall(int wallPos, WallType type) {

    }

    private enum WallType {
        HORIZONTAL,
        VERTICAL;
    }
}
