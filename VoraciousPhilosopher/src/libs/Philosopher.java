package libs;

import java.util.concurrent.TimeUnit;

/**
 * Philosopher représente un philosophe dans la première partie du problème des philosophes,
 * utilisant des mutex pour gérer l'accès aux fourchettes.
 */
public class Philosopher extends Thread {
    private final int id; // Identifiant unique pour le philosophe
    private final Fork leftFork; // Fourchette à gauche du philosophe
    private final Fork rightFork; // Fourchette à droite du philosophe
    private final long timeToDie; // Temps maximal avant la mort si le philosophe ne mange pas
    private final long timeToEat; // Temps que prend un philosophe pour manger
    private final long timeToSleep; // Temps que prend un philosophe pour dormir
    private int meals = 0; // Compteur du nombre de repas pris
    private final int numberOfMeals; // Nombre de repas qu'un philosophe doit prendre

    /**
     * Constructeur pour Philosopher.
     *
     * @param id Identifiant unique pour le philosophe.
     * @param leftFork Référence à la fourchette gauche.
     * @param rightFork Référence à la fourchette droite.
     * @param timeToDie Temps maximal avant la mort sans manger.
     * @param timeToEat Temps pris pour manger.
     * @param timeToSleep Temps pris pour dormir.
     * @param numberOfMeals Nombre de repas requis avant la fin de la simulation.
     */
    public Philosopher(int id, Fork leftFork, Fork rightFork, long timeToDie, long timeToEat, long timeToSleep, int numberOfMeals) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.timeToDie = timeToDie;
        this.timeToEat = timeToEat;
        this.timeToSleep = timeToSleep;
        this.numberOfMeals = numberOfMeals;
    }

    /**
     * La méthode run() définit le comportement du philosophe,
     * qui alterne entre penser, prendre les fourchettes, manger, et dormir.
     */
    @Override
    public void run() {
        try {
            while (numberOfMeals == -1 || meals < numberOfMeals) {
                think();
                pickUpForks(); // Prend les deux fourchettes (verrouille)
                eat();
                putDownForks(); // Pose les fourchettes (déverrouille)
                sleep();
            }
        } catch (InterruptedException e) {
            System.out.println(System.currentTimeMillis() + " " + id + " est mort");
        }
    }

    // Simule la réflexion du philosophe
    private void think() throws InterruptedException {
        System.out.println(System.currentTimeMillis() + " " + id + " est en train de réfléchir");
        TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 10));
    }

    // Le philosophe prend les fourchettes
    private void pickUpForks() {
        leftFork.pickUp();
        System.out.println(System.currentTimeMillis() + " " + id + " a pris une fourchette");
        rightFork.pickUp();
        System.out.println(System.currentTimeMillis() + " " + id + " a pris une fourchette");
    }

    // Simule le repas du philosophe
    private void eat() throws InterruptedException {
        System.out.println(System.currentTimeMillis() + " " + id + " est en train de manger");
        meals++;
        TimeUnit.MILLISECONDS.sleep(timeToEat);
    }

    // Le philosophe pose les fourchettes
    private void putDownForks() {
        leftFork.putDown();
        rightFork.putDown();
    }

    // Simule le sommeil du philosophe
    private void sleep() throws InterruptedException {
        System.out.println(System.currentTimeMillis() + " " + id + " est en train de dormir");
        TimeUnit.MILLISECONDS.sleep(timeToSleep);
    }
}
