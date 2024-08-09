package libs;

import java.util.concurrent.TimeUnit;

public class Philosopher extends Thread {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private final long timeToDie;
    private final long timeToEat;
    private final long timeToSleep;
    private int meals = 0;
    private final int numberOfMeals;

    public Philosopher(int id, Fork leftFork, Fork rightFork, long timeToDie, long timeToEat, long timeToSleep, int numberOfMeals) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
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
                pickUpForks();
                eat();
                putDownForks();
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

    private void pickUpForks() {
        leftFork.pickUp();
        System.out.println(System.currentTimeMillis() + " " + id + " a pris une fourchette");
        rightFork.pickUp();
        System.out.println(System.currentTimeMillis() + " " + id + " a pris une fourchette");
    }

    private void eat() throws InterruptedException {
        System.out.println(System.currentTimeMillis() + " " + id + " est en train de manger");
        meals++;
        TimeUnit.MILLISECONDS.sleep(timeToEat);
    }

    private void putDownForks() {
        leftFork.putDown();
        rightFork.putDown();
    }

    private void sleep() throws InterruptedException {
        System.out.println(System.currentTimeMillis() + " " + id + " est en train de dormir");
        TimeUnit.MILLISECONDS.sleep(timeToSleep);
    }
}
