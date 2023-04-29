public class Map {

    private static String[][] map = new String[0][];

    public Map(int numCols, int numRows) {
        map = new String[numRows + 2][numCols + 2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j ++) {
                if (i == 0) map[i][j] = "_";
                else if (i == map.length - 1) map[i][j] = "‾";
                else if (j == map[i].length - 1) map[i][j] = "▕";
                else if (j == 0) map[i][j] = "▏";
                else map[i][j] = "□";
            }
        }
    }

    public static void update(int col, int row, String value) {
        if (row >= 1 && row <= map.length - 2 && col >= 1 && col <= map.length - 2) {
            map[row][col] = value;
        }
    }

    public static void print2d() {
        for (String[] row: map) {
            for (String col: row) {
                System.out.print(col + "  ");
            }
            System.out.println();
        }
    }
}
