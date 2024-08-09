package libs;

import java.util.concurrent.TimeUnit;

public class SemaPhilo extends Thread {
    private final int id;
    private final Forks forks;
    private final long timeToDie;
    private final long timeToEat;
    private final long timeToSleep;
    private int meals = 0;
    private final int numberOfMeals;

    public SemaPhilo(int id, Forks forks, long timeToDie, long timeToEat, long timeToSleep, int numberOfMeals) {
        this.id = id;
        this.forks = forks;
        this.timeToDie = timeToDie;
        this.timeToEat = timeToEat;
        this.timeToSleep = timeToSleep;
        this.numberOfMeals = numberOfMeals;
    }

    @Override
    public void run() {
        try {
            while (numberOfMeals == -1 || meals < numberOfMeals) {
                think();
                forks.pickUp();
                eat();
                forks.putDown();
                sleep();
            }
        } catch (InterruptedException e) {
            System.out.println(System.currentTimeMillis() + " " + id + " est mort");
        }
    }

    private void think() throws InterruptedException {
        System.out.println(System.currentTimeMillis() + " " + id + " est en train de réfléchir");
        TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 10));
    }

    private void eat() throws InterruptedException {
        System.out.println(System.currentTimeMillis() + " " + id + " est en train de manger");
        meals++;
        TimeUnit.MILLISECONDS.sleep(timeToEat);
    }

    private void sleep() throws InterruptedException {
        System.out.println(System.currentTimeMillis() + " " + id + " est en train de dormir");
        TimeUnit.MILLISECONDS.sleep(timeToSleep);
    }
}
