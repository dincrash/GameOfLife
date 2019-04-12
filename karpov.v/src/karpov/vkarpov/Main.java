package karpov.vkarpov;

import edu.princeton.cs.introcs.StdDraw;

import java.util.Timer;
import java.util.TimerTask;

import static edu.princeton.cs.introcs.StdDraw.show;

public class Main {

    //размер поля 100х100 точек
    public static final int x = 100;
    public static final int y = 100;
    //количество живых точек
    public static final int seedCount = 1000;
    //размер холста
    public static final int xx = 1000;
    public static final int yy = 1000;
    public static final double penRadius = 0.005;

    public static void main(String[] args) {


        GameOfLife gameOfLife = new GameOfLife(x, y, xx, yy, penRadius);
        gameOfLife.growSeed(seedCount, x, y);
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
        timer.schedule(new Update(), 0, 100);


    }
}



