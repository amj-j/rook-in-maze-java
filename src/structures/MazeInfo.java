package structures;

public class MazeInfo {
    public int width;
    public int height;

    public boolean[][] horizontalWalls;
    public boolean[][] verticalWalls;

    public MazeInfo() {}

    public MazeInfo(int width, int height) {
        this.width = width;
        this.height = height;
        initWalls();
    }

    public void initWalls() {
        setHorizontalWalls();
        setVerticalWalls();
    }

    public void setHorizontalWalls() {
        horizontalWalls = new boolean[width][height-1];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height-1; y++) {
                horizontalWalls[x][y] = true;
            }
        }
    }

    public void setVerticalWalls() {
        verticalWalls = new boolean[width-1][height];
        for (int x = 0; x < width-1; x++) {
            for (int y = 0; y < height; y++) {
                verticalWalls[x][y] = true;
            }
        }
    }
}
