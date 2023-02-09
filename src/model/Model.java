package model;

import interfaces.ModelInterface;
import structures.*;

public class Model implements ModelInterface {
    MazeInfo maze;
    TileCoords playerPos;
    TileCoords finishPos;
    int gamesWon = 0;

    public MazeInfo newMaze() {
        MazeCreator mazeCreator = new MazeCreator();
        this.maze = mazeCreator.createMaze(DefaultValues.MAZE_WIDTH, DefaultValues.MAZE_HEIGHT);
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
                while (playerPos.x != chosenPos.x && !(maze.horizontalWalls[playerPos.x][y])) {
                    playerPos.x++;
                }
            }
            else if (playerPos.x > chosenPos.x) {
                while (playerPos.x != chosenPos.x && !(maze.horizontalWalls[playerPos.x-1][y])) {
                    playerPos.x--;
                }
            }
        }
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
}
