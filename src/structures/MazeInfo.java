package structures;

public class MazeInfo {
    public int columns;
    public int rows;

    public boolean[][] horizontalWalls;
    public boolean[][] verticalWalls;

    public MazeInfo() {}

    public MazeInfo(int width, int height) {
        this.columns = width;
        this.rows = height;
        initWalls();
    }

    public void initWalls() {
        setHorizontalWalls();
        setVerticalWalls();
    }

    public void setHorizontalWalls() {
        horizontalWalls = new boolean[columns][rows-1];
        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows-1; y++) {
                horizontalWalls[x][y] = true;
            }
        }
    }

    public void setVerticalWalls() {
        verticalWalls = new boolean[columns-1][rows];
        for (int x = 0; x < columns-1; x++) {
            for (int y = 0; y < rows; y++) {
                verticalWalls[x][y] = true;
            }
        }
    }
}
