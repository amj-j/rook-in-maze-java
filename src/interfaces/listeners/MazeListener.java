package interfaces.listeners;

import structures.TileCoords;

public interface MazeListener {
    public void mazeClicked(TileCoords coords);
    public void leftPressed();
    public void rightPressed();
    public void upPressed();
    public void downPressed();
}
