package model;

import java.util.Random;
import java.util.ArrayList;

import structures.MazeInfo;
import structures.TileCoords;

public class MazeCreator {
    MazeInfo maze;
    boolean[][] tiles;
    Random random;


    public MazeInfo createMaze(int width, int height) {
        this.maze = new MazeInfo(width, height);
        this.tiles = new boolean[width][height];
        this.random = new Random();
        setWalls();
        return this.maze;
    }

    private void setWalls() {
        randomizedDFS(DefaultValues.STARTING_POS);
    }
    
    private void randomizedDFS(TileCoords tile) {
        markVisited(tile);
        TileCoords nextTile = getUnvisitedNeighbour(tile);
        while (nextTile != null) {
            removeWall(tile, nextTile);
            randomizedDFS(nextTile);
            nextTile = getUnvisitedNeighbour(tile);
        }
    }

    private TileCoords getUnvisitedNeighbour(TileCoords tile) {
        ArrayList<TileCoords> unvisitedNeighbours = getUnvisitedNeighbours(tile);
        if (unvisitedNeighbours.isEmpty()) {
            return null;
        }
        int randIndex = random.nextInt(unvisitedNeighbours.size());
        return unvisitedNeighbours.get(randIndex);
    }

    private ArrayList<TileCoords> getUnvisitedNeighbours(TileCoords tile) {
        ArrayList<TileCoords> list = new ArrayList<>();
        for (Neighbour neighbour : Neighbour.values()) {
            TileCoords neighbourTile = new TileCoords(tile.x + neighbour.getX(), tile.y + neighbour.getY());
            try {
                if (tiles[neighbourTile.x][neighbourTile.y] == false) {
                    list.add(neighbourTile);
                }
            }
            catch (IndexOutOfBoundsException e) { continue; }
        }
        return list;
    }

    private void markVisited(TileCoords tile) {
        tiles[tile.x][tile.y] = true;
    }

    private void removeWall(TileCoords tile1, TileCoords tile2) {
        if (tile1.x == tile2.x) {
            int x = tile1.x;
            if (tile1.y + 1 == tile2.y) {
                maze.horizontalWalls[x][tile1.y] = false;
            }
            else if (tile1.y - 1 == tile2.y) {
                maze.horizontalWalls[x][tile2.y] = false;
            }
        }
        else if (tile1.y == tile2.y) {
            int y = tile1.y;
            if (tile1.x + 1 == tile2.x) {
                maze.verticalWalls[tile1.x][y] = false;
            }
            else if (tile1.x - 1 == tile2.x) {
                maze.verticalWalls[tile2.x][y] = false;
            }
        }
    }

    private enum Neighbour {
        NORTH(0, -1),
        SOUTH(0, 1),
        EAST(1, 0),
        WEST(-1, 0);

        private final int x;
        private final int y;

        Neighbour(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
