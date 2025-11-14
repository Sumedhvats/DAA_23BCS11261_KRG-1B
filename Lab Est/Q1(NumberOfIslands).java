class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, vis, i, j);
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, boolean[][] vis, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;

        vis[x][y] = true;

        int[] row = {0, 1, 0, -1};
        int[] col = {1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            int xi = x + row[i];
            int yi = y + col[i];

            if (xi >= 0 && xi < n && yi >= 0 && yi < m &&
                !vis[xi][yi] && grid[xi][yi] == '1') {

                dfs(grid, vis, xi, yi);
            }
        }
    }
}
