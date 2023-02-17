package interfaces.listeners;

import structures.MazeSize;

public interface MenuListener {
    public void reset();
    public void changeMazeSize(MazeSize newSize);
}
