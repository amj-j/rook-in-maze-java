package structures;

public class MazeInfo {
    public int width;
    public int height;

    public boolean[] horizontalWalls;
    public boolean[] verticalWalls;

    public MazeInfo() {}

    public MazeInfo(int width, int height) {
        this.width = width;
        this.height = height;
        setHorizontalWalls();
        setVerticalWalls();
    }

    public void setWidth(int width) {
        this.width = width;
        setVerticalWalls();
    }

    public void setHeight(int height) {
        this.height = height;
        setHorizontalWalls();
    }

    public void setHorizontalWalls() {
        horizontalWalls = new boolean[height-1];
        for (int i = 0; i < height-1; i++) {
            horizontalWalls[i] = true;
        }
    }

    public void setVerticalWalls() {
        verticalWalls = new boolean[width-1];
        for (int i = 0; i < width-1; i++) {
            verticalWalls[i] = true;
        }
    }
}
