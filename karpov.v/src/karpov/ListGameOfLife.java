package karpov;

import edu.princeton.cs.introcs.StdDraw;

import java.util.ArrayList;
import java.util.List;

public class ListGameOfLife {

    List<Cell> populate = new ArrayList<>();
    List<Cell> newPopulate = new ArrayList<>();

    public ListGameOfLife(int rows, int cols, int canvasWidth, int canvasHeight, double penRadius) {
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.setXscale(0, rows);
        StdDraw.setYscale(0, cols);
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.setPenRadius(penRadius);
        StdDraw.enableDoubleBuffering();
    }

    public void growSeed(int seedCount, int row, int col) {
        for (int i = 0; i < seedCount; i++) {
            newPopulate.add(i, new Cell(0, 0));
        }
//        рандомные числа
        for (int i = 0; i < seedCount; i++) {
            int x = (int) (Math.random() * row);
            int y = (int) (Math.random() * col);
            populate.add(i, new Cell(x, y));
        }
//        глайдер
//        populate.add(0, new Cell(5, 5));
//        populate.add(1, new Cell(4, 5));
//        populate.add(2, new Cell(6, 5));
//        populate.add(3, new Cell(6, 4));
//        populate.add(4, new Cell(5, 3));
//        столб
//        populate.add(5, new Cell(1, 2));
//        populate.add(6, new Cell(1, 3));
//        populate.add(7, new Cell(1, 4));
    }

    //отрисовка
    public void print(int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (populate.contains(new Cell(i, j))) {
                    StdDraw.point(i, j);
                }
            }
        }
    }

    public int getLivingNeighbors(int x, int y) {
        int count = 0;
        //вверх
            if (populate.contains(new Cell(x, y - 1))) {
                count++;
            }
        // лево
            if (populate.contains(new Cell(x - 1, y))) {
                count++;
            }
        //вверх лево
            if (populate.contains(new Cell(x - 1, y - 1))) {
                count++;
            }
        // право
            if (populate.contains(new Cell(x + 1, y))) {
                count++;
            }
        //вверх право
            if (populate.contains(new Cell(x + 1, y - 1))) {
                count++;
            }
        //низ
            if (populate.contains(new Cell(x, y + 1))) {
                count++;
            }
        //низ право
            if (populate.contains(new Cell(x + 1, y + 1))) {
                count++;
            }
        //низ лево
            if (populate.contains(new Cell(x - 1, y + 1))) {
                count++;
            }
        return count;
    }

    public void update(int rows, int cols, int seedCount) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int dp = getLivingNeighbors(i, j);
                if (populate.contains(new Cell(i, j))) {
                    if (dp < 2) {
                        newPopulate.remove(new Cell(i, j));
                    }
                    if (dp == 2 || dp == 3) {
                        int ind = populate.indexOf(new Cell(i, j));
                        if (!newPopulate.contains(new Cell(i, j))) {
                            newPopulate.add(ind, new Cell(i, j));
                        }
                    }
                    if (dp > 3) {
                        newPopulate.remove(new Cell(i, j));
                    }
                }
                if (!populate.contains(new Cell(i, j))) {
                    if (dp == 3) {
                        {
                            for (int index = 0; index < seedCount; index++) {
                                if ((index >= populate.size()) | (populate.contains(new Cell(0, 0)))) {
                                    newPopulate.add(index, new Cell(i, j));
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        nextState();
    }

    public void nextState() {
        populate = new ArrayList(newPopulate);
    }
}