import java.util.Timer;
import java.util.TimerTask;

public class main {

    public static void main(String[] args) {

        //размер поля 100х100 точек
        int x= 100;
        int y=100;
        //количество живых точек
        int seedCount= 1000;

        GameOfLife gameOfLife = new GameOfLife(x, y,1000,1000);
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



