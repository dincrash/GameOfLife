package karpov.v;

import edu.princeton.cs.introcs.StdDraw;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {

        //размер поля 100х100 точек
        final int x = 10;
        final int y = 10;
        //количество живых точек
        final int seedCount = 10;
        //размер холста
        final int xx = 1000;
        final int yy = 1000;

        GameOfLife gameOfLife = new GameOfLife(x, y, xx, yy);
        gameOfLife.growSeed(seedCount, x, y);
        gameOfLife.print();

        //обновление поля
//        StdDraw.clear();
//        gameOfLife.update();
//        gameOfLife.print();
//
//        StdDraw.clear();
//        gameOfLife.update();
//        gameOfLife.print();

        class SayHello extends TimerTask {
            public void run() {
                StdDraw.clear();
                gameOfLife.update();
                gameOfLife.print();
            }
        }

        Timer timer = new Timer();
        timer.schedule(new SayHello(), 0, 1000);


    }
}



