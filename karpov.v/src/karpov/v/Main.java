package karpov.v;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {

        //размер поля 100х100 точек
        final int x= 100;
        final int y=100;
        //количество живых точек
        final int seedCount= 1000;
        //размер холста
        final int xx=1000;
        final int yy=1000;

        GameOfLife gameOfLife = new GameOfLife(x, y,xx,yy);
        gameOfLife.growSeed(seedCount,x, y);
        gameOfLife.print();

        //обновление поля

        class SayHello extends TimerTask {
            public void run() {
                gameOfLife.update();
                gameOfLife.nextState();
                gameOfLife.print();
            }
        }

        Timer timer = new Timer();
        timer.schedule(new SayHello(), 0, 5000);


    }
}



