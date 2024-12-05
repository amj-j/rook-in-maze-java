package interfaces.viewInterfaces;

import interfaces.listeners.MazeListener;
import structures.*;

public interface MazeView {
    public void newMaze(MazeInfo mazeInfo);
    public void setFinishPos(TileCoords coords);
    public void setPlayerPos(TileCoords coords);
    public void addListener(MazeListener listener);
}
