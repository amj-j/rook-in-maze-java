package interfaces;

import structures.*;

public interface MazeViewInterface {
    public void newMaze(MazeInfo mazeInfo);
    public void initPlayer(TileCoords tile);
    public void setFinish(TileCoords tile);
    public void moveTo(TileCoords tile);
}
