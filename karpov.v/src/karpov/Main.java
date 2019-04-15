package karpov;

import edu.princeton.cs.introcs.StdDraw;

import java.util.Timer;
import java.util.TimerTask;

import static edu.princeton.cs.introcs.StdDraw.show;

public class Main {

    //размер поля 100х100 точек
    public static final int X_COUNT_PIXEL = 10;
    public static final int Y_COUNT_PIXEL = 10;
    //количество живых точек
    public static final int SEED_COUNT = 90;
    //размер холста
    public static final int X_SIZE_CANVAS = 1000;
    public static final int Y_SIZE_CANVAS = 1000;
    //размер пикселя
    public static final double PEN_RADIUS = 0.05;
    //время обновление
    public static final int TIME_UPDATE = 500;

    public static void main(String[] args) {
//        на листах
        ListGameOfLife listGameOfLife = new ListGameOfLife(X_COUNT_PIXEL, Y_COUNT_PIXEL, X_SIZE_CANVAS, Y_SIZE_CANVAS, PEN_RADIUS);
        listGameOfLife.growSeed(SEED_COUNT, X_COUNT_PIXEL, Y_COUNT_PIXEL);
        class Update extends TimerTask {
            public void run() {
                StdDraw.clear();
                listGameOfLife.print(X_COUNT_PIXEL,Y_COUNT_PIXEL);
                listGameOfLife.update(X_COUNT_PIXEL,Y_COUNT_PIXEL,SEED_COUNT);
                show();
            }
        }
        Timer timer = new Timer();
        timer.schedule(new Update(), 0, TIME_UPDATE);

        //на массивах
//        GameOfLife gameOfLife = new GameOfLife(X_COUNT_PIXEL, Y_COUNT_PIXEL, X_SIZE_CANVAS, Y_SIZE_CANVAS, PEN_RADIUS);
//        gameOfLife.growSeed(SEED_COUNT, X_COUNT_PIXEL, Y_COUNT_PIXEL);
//        gameOfLife.print();
//        class Update extends TimerTask {
//            public void run() {
//                StdDraw.clear();
//                gameOfLife.print();
//                show();
//                gameOfLife.update();
//            }
//        }
//        Timer timer = new Timer();
//        timer.schedule(new Update(), 0, TIME_UPDATE);
    }
}



