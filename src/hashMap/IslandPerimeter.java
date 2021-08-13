package hashMap;

public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                   ans += getPerimeter(i, j, grid);
                }
            }
        }

        return ans;
    }

    public static int getPerimeter(int i, int j, int[][] grid) {
        int ans = 4;

        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            ans--;
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
            ans--;
        }
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            ans--;
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            ans--;
        }
        return ans;
    }
}
