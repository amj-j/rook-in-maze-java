package model;

import interfaces.model.ModelInterface;
import structures.*;

public class Model implements ModelInterface {
    private MazeInfo maze;
    private TileCoords playerPos;
    private TileCoords finishPos;
    private int gamesWon = 0;
    private MazeSize mazeSize;

    public Model() {
        this.mazeSize = DefaultValues.MAZE_SIZE;
    }

    public MazeInfo newMaze() {
        MazeCreator mazeCreator = new MazeCreator();
        this.maze = mazeCreator.createMaze(mazeSize);
        return this.maze;
    }

    public TileCoords initPlayer(TileCoords startPos) {
        this.playerPos = startPos;
        return this.playerPos;
    }

    public TileCoords setFinish(TileCoords finishTilePos) {
        this.finishPos = finishTilePos;
        return this.finishPos;
    }

    public TileCoords moveTo(TileCoords chosenPos) {
        if (chosenPos.x != playerPos.x && chosenPos.y != playerPos.y) {
            return null;
        }
        if (chosenPos.x == playerPos.x && chosenPos.y == playerPos.y) {
            return null;
        }
        if (chosenPos.x == playerPos.x) {
            int x = chosenPos.x;
            if (playerPos.y < chosenPos.y) {
                while (playerPos.y != chosenPos.y && !(maze.horizontalWalls[x][playerPos.y])) {
                    playerPos.y++;
                }
            }
            else if (playerPos.y > chosenPos.y) {
                while (playerPos.y != chosenPos.y && !(maze.horizontalWalls[x][playerPos.y-1])) {
                    playerPos.y--;
                }
            }
        }
        else if (chosenPos.y == playerPos.y) {
            int y = chosenPos.y;
            if (playerPos.x < chosenPos.x) {
                while (playerPos.x != chosenPos.x && !(maze.verticalWalls[playerPos.x][y])) {
                    playerPos.x++;
                }
            }
            else if (playerPos.x > chosenPos.x) {
                while (playerPos.x != chosenPos.x && !(maze.verticalWalls[playerPos.x-1][y])) {
                    playerPos.x--;
                }
            }
        }
        return this.playerPos;
    }

    public TileCoords moveLeft() {
        if (playerPos.x - 1 < 0 || maze.verticalWalls[playerPos.x-1][playerPos.y]) {
            return null;
        }
        playerPos.x--;
        return this.playerPos;
    }

    public TileCoords moveRight() {
        if (playerPos.x + 1 >= maze.size.cols || maze.verticalWalls[playerPos.x][playerPos.y]) {
            return null;
        }
        playerPos.x++;
        return this.playerPos;
    }

    public TileCoords moveUp() {
        if (playerPos.y - 1 < 0 || maze.horizontalWalls[playerPos.x][playerPos.y-1]) {
            return null;
        }
        playerPos.y--;
        return this.playerPos;
    }

    public TileCoords moveDown() {
        if (playerPos.y + 1 >= maze.size.rows || maze.horizontalWalls[playerPos.x][playerPos.y]) {
            return null;
        }
        playerPos.y++;
        return this.playerPos;
    }

    public boolean hasWon() {
        if (playerPos.x == finishPos.x && playerPos.y == finishPos.y) {
            gamesWon++;
            return true;
        }
        else {
            return false;
        }
    }

    public int getWonGames() {
        return this.gamesWon;
    }

    public void resetWonGames() {
        this.gamesWon = 0;
    }

    public void setMazeSize(MazeSize newSize) {
        this.mazeSize = newSize;
    }
}
