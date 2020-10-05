
public class MineSweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        boolean[][] mines = new boolean[m][n];

        int b = 0;
        while (b < k) {
            int ri = (int) (Math.random() * m);
            int rj = (int) (Math.random() * n);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (ri == i && rj == j && !mines[i][j]) {
                        mines[i][j] = true;
                        b++;
                    }
                }
            }
        }


        boolean[][] mines2 = new boolean[m + 2][n + 2];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                mines2[i][j] = mines[i - 1][j - 1];
            }
        }

        int[][] grid = new int[m + 2][n + 2];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (!mines2[i][j]) {
                    if (mines2[i - 1][j - 1]) grid[i][j]++;
                    if (mines2[i - 1][j]) grid[i][j]++;
                    if (mines2[i - 1][j + 1]) grid[i][j]++;
                    if (mines2[i][j + 1]) grid[i][j]++;
                    if (mines2[i + 1][j + 1]) grid[i][j]++;
                    if (mines2[i + 1][j]) grid[i][j]++;
                    if (mines2[i + 1][j - 1]) grid[i][j]++;
                    if (mines2[i][j - 1]) grid[i][j]++;
                }
            }
        }

        String[][] grid2 = new String[m + 2][n + 2];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (mines2[i][j]) grid2[i][j] = "*";
                else grid2[i][j] = Integer.toString(grid[i][j]);
            }
        }


        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(grid2[i][j] + "  ");
            }
            System.out.println();
        }

    }
}


