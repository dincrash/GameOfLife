import edu.princeton.cs.introcs.StdDraw;

public class GameOfLife {
    int[][] size;
    int[][] society;
    int[][] newSociety;


    public GameOfLife(int rows, int cols,int canvasWidth,int canvasHeight) {
        size = new int[rows][cols];
        newSociety = new int[rows][cols];
        society = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                society[r][c] = 0;
            }
        }

        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.setXscale(0, rows);
        StdDraw.setYscale(0, cols);
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.setPenRadius(0.005);
    }

    public void growSeed(int seedCount,int row, int col) {
//         рандомные числа
        for (int i = 0; i < seedCount; i++) {
            int x = (int) (Math.random() * row);
            int y = (int) (Math.random() * col);
            society[x][y] = 1;

        //проверочные
//        society[5][5] = 1;
//        society[4][5] = 1;
//        society[6][5] = 1;
//        society[2][3] = 1;
//        society[2][2] = 1;
//        society[3][3] = 1;
//        society[3][2] = 1;
//        society[9][9] = 1;
//        society[8][9] = 1;


        }
    }

    public void nextState() {
        society = newSociety;

    }


    public void print() {
        StdDraw.clear();
        for (int i = 0; i < society.length; i++) {
            for (int j = 0; j < society[i].length; j++) {

                if (society[i][j] == 1) {
                    StdDraw.point(j, i);

                } else {
                }
            }
        }

    }

    public int GetLivingNeighbors(int x, int y) {
        int count = 0;
        // право
        if (x != size.length - 1)
            if (society[x + 1][y] == 1)
                count++;
        // лево
        if (x != 0)
            if (society[x - 1][y] == 1)
                count++;
        // вверх
        if (y != 0)
            if (society[x][y - 1] == 1)
                count++;
        //низ
        if (y != size.length - 1)
            if (society[x][y + 1] == 1)
                count++;
        //вверх право
        if (y != 0 && x != size.length - 1)
            if (society[x + 1][y - 1] == 1)
                count++;
        //вверх лево
        if (y != 0 && x != 0)
            if (society[x - 1][y - 1] == 1)
                count++;
        //низ право
        if (y != size.length - 1 && x != size.length - 1)
            if (society[x + 1][y + 1] == 1)
                count++;
        //низ лево
        if (y != size.length - 1 && x != 0)
            if (society[x - 1][y + 1] == 1)
                count++;

        return count;
    }


    public void update() {

        for (int i = 0; i < society.length; i++) {
            for (int j = 0; j < society[i].length; j++) {
                int dp = GetLivingNeighbors(i, j);

                // ввод правил игры

                if (society[i][j] == 1) {

                    if (dp < 2)
                        newSociety[i][j] = 0;

                    if (dp == 2 || dp == 3) {
                        newSociety[i][j] = 1;
                    }
                    if (dp > 3)
                        newSociety[i][j] = 0;

                }
                if (society[i][j] == 0) {
                    if (dp == 3) {
                        newSociety[i][j] = 1;
                    }
                }


            }
        }
    }
}