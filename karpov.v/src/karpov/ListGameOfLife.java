package karpov;

import edu.princeton.cs.introcs.StdDraw;

import java.util.ArrayList;
import java.util.List;

public class ListGameOfLife {

    List<Cell> populate = new ArrayList<>();






    public ListGameOfLife(int rows, int cols, int canvasWidth, int canvasHeight, double penRadius) {

        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.setXscale(0, rows);
        StdDraw.setYscale(0, cols);
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.setPenRadius(penRadius);
        StdDraw.enableDoubleBuffering();


    }

    public void growSeed(int seedCount, int row, int col) {

//                 рандомные числа
//        for (int i = 0; i < seedCount; i++) {
//            int x = (int) (Math.random() * row);
//            int y = (int) (Math.random() * col);
//            populate.add(i, new Cell(x, y));
//        }

//        глайдер
        populate.add(0, new Cell(5, 5));
        populate.add(1, new Cell(4, 5));
        populate.add(2, new Cell(6, 5));
        populate.add(3, new Cell(6, 4));
        populate.add(4, new Cell(5, 3));

    }

    //отрисовка
    public void print(int rows,int cols){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (populate.contains(new Cell(i, j))) {

                    StdDraw.point(i, j);
                }
            }
        }
    }




}