import libs.Fork;
import libs.Forks;
import libs.Philosopher;
import libs.SemaPhilo;

/*
* PARTIE 1
*/
//public class Main {
//    public static void main(String[] args) {
//        int numberOfPhilosophers = 5;
//        long timeToDie = 1000;
//        long timeToEat = 200;
//        long timeToSleep = 100;
//        int numberOfMeals = 3;
//
//        Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];
//        Fork[] forks = new Fork[numberOfPhilosophers];
//
//        for (int i = 0; i < numberOfPhilosophers; i++) {
//            forks[i] = new Fork();
//        }
//
//        for (int i = 0; i < numberOfPhilosophers; i++) {
//            Fork leftFork = forks[i];
//            Fork rightFork = forks[(i + 1) % numberOfPhilosophers];
//
//            philosophers[i] = new Philosopher(i + 1, leftFork, rightFork, timeToDie, timeToEat, timeToSleep, numberOfMeals);
//            philosophers[i].start();
//        }
//
//        for (Philosopher philosopher : philosophers) {
//            try {
//                philosopher.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}

/**
 * PARTIE 2
 */
public class Main {
    public static void main(String[] args) {
        int numberOfPhilosophers = 5;
        long timeToDie = 1000;
        long timeToEat = 200;
        long timeToSleep = 100;
        int numberOfMeals = 3;

        Forks forks = new Forks(numberOfPhilosophers);

        SemaPhilo[] semaPhilos = new SemaPhilo[numberOfPhilosophers];

        for (int i = 0; i < numberOfPhilosophers; i++) {
            semaPhilos[i] = new SemaPhilo(i + 1, forks, timeToDie, timeToEat, timeToSleep, numberOfMeals);
            semaPhilos[i].start();
        }

        for (SemaPhilo semaPhilo : semaPhilos) {
            try {
                semaPhilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

