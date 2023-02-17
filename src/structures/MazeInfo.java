package structures;

public class MazeInfo {
    public MazeSize size;

    public boolean[][] horizontalWalls;
    public boolean[][] verticalWalls;

    public MazeInfo() {}

    public MazeInfo(MazeSize size) {
        this.size = size;
        initWalls();
    }

    public void initWalls() {
        setHorizontalWalls();
        setVerticalWalls();
    }

    public void setHorizontalWalls() {
        horizontalWalls = new boolean[size.cols][size.rows-1];
        for (int x = 0; x < size.cols; x++) {
            for (int y = 0; y < size.rows-1; y++) {
                horizontalWalls[x][y] = true;
            }
        }
    }

    public void setVerticalWalls() {
        verticalWalls = new boolean[size.cols-1][size.rows];
        for (int x = 0; x < size.cols-1; x++) {
            for (int y = 0; y < size.rows; y++) {
                verticalWalls[x][y] = true;
            }
        }
    }
}
