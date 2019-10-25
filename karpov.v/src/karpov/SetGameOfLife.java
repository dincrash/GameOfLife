package karpov;

import edu.princeton.cs.introcs.StdDraw;

import java.util.HashSet;
import java.util.Set;

public class SetGameOfLife {

    Set<Cell> populate = new HashSet<>();
    Set<Cell> newPopulate = new HashSet<>();
        
    public SetGameOfLife(int rows, int cols, int canvasWidth, int canvasHeight, double penRadius) {
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.setXscale(0, rows);
        StdDraw.setYscale(0, cols);
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.setPenRadius(penRadius);
        StdDraw.enableDoubleBuffering();
    }

    public void growSeed(int seedCount, int row, int col) {
//        for (int i = 0; i < seedCount; i++) {
//            newPopulate.add(new Cell(0, 0));
//        }
//        рандомные числа
        for (int i = 0; i < seedCount; i++) {
            int x = (int) (Math.random() * row);
            int y = (int) (Math.random() * col);
            populate.add(new Cell(x, y));
        }
//        глайдер
//        populate.add(new Cell(5, 5));
//        populate.add(new Cell(4, 5));
//        populate.add(new Cell(6, 5));
//        populate.add(new Cell(6, 4));
//        populate.add(new Cell(5, 3));
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

    public void update(int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int dp = getLivingNeighbors(i, j);
                if (populate.contains(new Cell(i, j))) {
                    if (dp < 2) {
                        newPopulate.remove(new Cell(i, j));
                    }
                    if (dp == 2 || dp == 3) {
                        newPopulate.add(new Cell(i, j));
                    }
                    if (dp > 3) {
                        newPopulate.remove(new Cell(i, j));
                    }
                }
                if (!populate.contains(new Cell(i, j))) {
                    if (dp == 3) {
                        newPopulate.add(new Cell(i, j));
                    }
                }
            }
        }
        nextState();
    }

    public void nextState() {
        populate = new HashSet<>(newPopulate);
    }

}
