package interfaces.modelInterfaces;

import structures.*;

public interface ModelInterface {
    public MazeInfo newMaze();
    public TileCoords initPlayer(TileCoords tile);
    public TileCoords setFinish(TileCoords tile);
    public TileCoords moveTo(TileCoords tile);
    public boolean hasWon();
    public int getWonGames();
    public void resetWonGames();
    public void addWonGame();
    public void setMazeSize(MazeSize newSize);
}
