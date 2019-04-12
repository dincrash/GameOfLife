package karpov.v;

import edu.princeton.cs.introcs.StdDraw;

public class GameOfLife {
    int[][] size;
    int[][] society;
    int[][] newSociety;

    public GameOfLife(int rows, int cols, int canvasWidth, int canvasHeight) {
        size = new int[rows][cols];
        newSociety = new int[rows][cols];
        society = new int[rows][cols];

        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.setXscale(0, rows);
        StdDraw.setYscale(0, cols);
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.setPenRadius(0.05);
    }

    public void growSeed(int seedCount, int row, int col) {
//         рандомные числа
//        for (int i = 0; i < seedCount; i++) {
//            int x = (int) (Math.random() * row);
//            int y = (int) (Math.random() * col);
//            society[x][y] = 1;
//    }

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

//        глайдер
        society[5][5] = 1;
        society[4][5] = 1;
        society[6][5] = 1;
        society[6][4] = 1;
        society[5][3] = 1;
    }

    public void nextState() {
        for (int i = 0; i < size.length; i++)
            for (int j = 0; j < size[i].length; j++)
                society[i][j] = newSociety[i][j];
    }


    public void print() {
        for (int i = 0; i < society.length; i++) {
            for (int j = 0; j < society[i].length; j++) {

                if (society[i][j] == 1) {
                    StdDraw.point(j, i);
                }
            }

        }
    }

    public int getLivingNeighbors(int x, int y) {
        int count = 0;
        // право
        if (x != size.length - 1) {
            count += society[x + 1][y];
        }
        // лево
        if (x != 0) {
            count += society[x - 1][y];
        }

        // вверх
        if (y != 0) {
            count += society[x][y - 1];
        }

        //низ
        if (y != size.length - 1) {
            count += society[x][y + 1];
        }

        //вверх право
        if (y != 0 && x != size.length - 1) {
            count += society[x + 1][y - 1];
        }

        //вверх лево
        if (y != 0 && x != 0) {
            count += society[x - 1][y - 1];
        }

        //низ право
        if (y != size.length - 1 && x != size.length - 1) {
            count += society[x + 1][y + 1];
        }

        //низ лево
        if (y != size.length - 1 && x != 0) {
            count += society[x - 1][y + 1];
        }

        return count;
    }


    public void update() {
        for (int i = 0; i < society.length; i++) {
            for (int j = 0; j < society[i].length; j++) {
                int dp = getLivingNeighbors(i, j);

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
        nextState();

    }
}