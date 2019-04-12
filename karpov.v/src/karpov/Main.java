package karpov;

import edu.princeton.cs.introcs.StdDraw;

import java.util.Timer;
import java.util.TimerTask;

import static edu.princeton.cs.introcs.StdDraw.show;

public class Main {

    //размер поля 100х100 точек
    public static final int X_COUNT_PIXEL= 100;
    public static final int Y_COUNT_PIXEL = 100;
    //количество живых точек
    public static final int SEED_COUNT = 1000;
    //размер холста
    public static final int X_SIZE_CANVAS = 1000;
    public static final int Y_SIZE_CANVAS = 1000;
    //размер пикселя
    public static final double PEN_RADIUS = 0.005;
    //время обновление
    public static final int TIME_UPDATE = 100;

    public static void main(String[] args) {


        GameOfLife gameOfLife = new GameOfLife(X_COUNT_PIXEL, Y_COUNT_PIXEL, X_SIZE_CANVAS, Y_SIZE_CANVAS, PEN_RADIUS);
        gameOfLife.growSeed(SEED_COUNT, X_COUNT_PIXEL, Y_COUNT_PIXEL);
        gameOfLife.print();


//        обновление поля
//        StdDraw.clear();
//        gameOfLife.update();
//        gameOfLife.print();
//
//        StdDraw.clear();
//        gameOfLife.update();
//        gameOfLife.print();


        class Update extends TimerTask {
            public void run() {

                StdDraw.clear();
                gameOfLife.update();
                gameOfLife.print();
                show();

            }
        }

        Timer timer = new Timer();
        timer.schedule(new Update(), 0, TIME_UPDATE);


    }
}



