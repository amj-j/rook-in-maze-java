package interfaces.model;

import structures.*;

public interface ModelInterface {
    public MazeInfo newMaze();
    public TileCoords initPlayer(TileCoords tile);
    public TileCoords setFinish(TileCoords tile);
    public TileCoords moveTo(TileCoords tile);
    public TileCoords moveLeft();
    public TileCoords moveRight();
    public TileCoords moveUp();
    public TileCoords moveDown();
    public boolean hasWon();
    public int getWonGames();
    public void resetWonGames();
    public void setMazeSize(MazeSize newSize);
}
