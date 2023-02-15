package view;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;

import java.awt.event.*;

import structures.MazeInfo;
import structures.TileCoords;

public class MazeView extends Canvas {
    private MazeInfo mazeInfo;
    private TileCoords finishPos;
    private TileCoords playerPos;

    protected int tileSize;
    protected int offsetLeft;
    protected int offsetTop;

    private Color mazeColor = DefaultSettings.MAZE_COLOR;
    private Color wallColor = DefaultSettings.WALL_COLOR;
    private Color finishColor = DefaultSettings.FINISH_COLOR;
    private Color playerColor = DefaultSettings.PLAYER_COLOR;

    public MazeView() {
        setBackground(DefaultSettings.BG_COLOR);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setLayoutParameters();
                repaint();
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                int x = (event.getX() - offsetLeft)/tileSize;
                int y = (event.getY() - offsetTop)/tileSize;
                new TileCoords(x, y);
            }
        });
    }

    public void setMazeInfo(MazeInfo mazeInfo) {
        this.mazeInfo = mazeInfo;
        repaint();
    }

    public void setFinishPos(TileCoords newPos) {
        this.finishPos = newPos;
        repaint();
    }

    public void setPlayerPos(TileCoords newPos) {
        this.playerPos = newPos;
        repaint();
    }

    public void setLayoutParameters() {
        double canWHRatio = ((double) getWidth()) / ((double) getHeight());
        double mazeCRRatio = ((double) mazeInfo.columns) / ((double) mazeInfo.rows);
        if (canWHRatio > 1.0) {
            if (mazeCRRatio > 1.0) {
                if (canWHRatio < mazeCRRatio) {
                    constraintByWidth();
                }
                else {
                    constraintByHeight();
                }
            }
            else {
                constraintByHeight();
            }
        }
        else {
            if (mazeCRRatio < 1.0) {
                if (canWHRatio > mazeCRRatio) {
                    constraintByHeight();
                }
                else {
                    constraintByWidth();
                }
            }
            else {
                constraintByWidth();
            }
        } 
    }

    private void constraintByWidth() {
        this.tileSize = getWidth() / (mazeInfo.columns + 1);
        this.offsetLeft = this.tileSize/2;
        this.offsetTop = (getHeight() - this.tileSize * mazeInfo.rows)/2;
    }

    private void constraintByHeight() {
        this.tileSize = getHeight() / (mazeInfo.rows + 1);
        this.offsetLeft = (getWidth() - this.tileSize * mazeInfo.columns)/2;
        this.offsetTop = this.tileSize/2;
    }
    
    @Override
    public void paint(Graphics g) {
        if (mazeInfo != null) {
            drawMaze(g);
        }
        if (finishPos != null) {
            drawFinish(g);
        }
        if (playerPos != null) {
            drawPlayer(g);
        }
    }

    private void drawMaze(Graphics g) {
        g.setColor(wallColor);
        g.drawRect(offsetLeft, offsetTop, mazeInfo.columns*tileSize, mazeInfo.rows*tileSize);
        g.setColor(mazeColor);
        g.fillRect(offsetLeft, offsetTop, mazeInfo.columns*tileSize, mazeInfo.rows*tileSize);
        drawWalls(g);
    }

    private void drawWalls(Graphics g) {
        g.setColor(wallColor);
        for (int x = 0; x < mazeInfo.columns; x++) {
            for (int y = 0; y < mazeInfo.rows-1; y++) {
                if (mazeInfo.horizontalWalls[x][y] == true) {
                    drawHorizontalWall(g, x, y);
                }
            }
        }
        for (int x = 0; x < mazeInfo.columns-1; x++) {
            for (int y = 0; y < mazeInfo.rows; y++) {
                if (mazeInfo.verticalWalls[x][y] == true) {
                    drawVerticalWall(g, x, y);
                }
            }
        }
    }

    private void drawHorizontalWall(Graphics g, int x, int y) {
        int x1 = offsetLeft + tileSize * x;
        int x2 = offsetLeft + tileSize * (x + 1);
        y = offsetTop + tileSize * (y + 1);
        g.drawLine(x1, y, x2, y);
    }
    
    private void drawVerticalWall(Graphics g, int x, int y) {
        x = offsetLeft + tileSize * (x + 1);
        int y1 = offsetTop + tileSize * y;
        int y2 = offsetTop + tileSize * (y + 1);
        g.drawLine(x, y1, x, y2);
    }

    private void drawFinish(Graphics g) {
        g.setColor(finishColor);
        int x = offsetLeft + finishPos.x*tileSize;
        int y = offsetTop + finishPos.y*tileSize;
        g.fillRect(x, y, tileSize, tileSize);
    }

    private void drawPlayer(Graphics g) {
        int x = offsetLeft + playerPos.x*tileSize;
        int y = offsetTop + playerPos.y*tileSize;
        g.setColor(playerColor);
        int diameter = tileSize - 10;
        x += (tileSize - diameter) / 2;
        y += (tileSize - diameter) / 2;
        g.fillOval(x, y, diameter, diameter);
    }
}
