package libs;

import java.util.concurrent.TimeUnit;

/**
 * SemaPhilo représente un philosophe dans la deuxième partie du problème des philosophes,
 * utilisant un sémaphore pour gérer les fourchettes disponibles.
 */
public class SemaPhilo extends Thread {
    private final int id; // Identifiant unique pour le philosophe
    private final Forks forks; // Référence au sémaphore qui gère les fourchettes
    private final long timeToDie; // Temps maximal avant la mort si le philosophe ne mange pas
    private final long timeToEat; // Temps que prend un philosophe pour manger
    private final long timeToSleep; // Temps que prend un philosophe pour dormir
    private int meals = 0; // Compteur du nombre de repas pris
    private final int numberOfMeals; // Nombre de repas qu'un philosophe doit prendre

    /**
     * Constructeur pour SemaPhilo.
     *
     * @param id Identifiant unique pour le philosophe.
     * @param forks Référence au gestionnaire de fourchettes.
     * @param timeToDie Temps maximal avant la mort sans manger.
     * @param timeToEat Temps pris pour manger.
     * @param timeToSleep Temps pris pour dormir.
     * @param numberOfMeals Nombre de repas requis avant la fin de la simulation.
     */
    public SemaPhilo(int id, Forks forks, long timeToDie, long timeToEat, long timeToSleep, int numberOfMeals) {
        this.id = id;
        this.forks = forks;
        this.timeToDie = timeToDie;
        this.timeToEat = timeToEat;
        this.timeToSleep = timeToSleep;
        this.numberOfMeals = numberOfMeals;
    }

    /**
     * La méthode run() définit le comportement du philosophe,
     * qui alterne entre penser, manger, et dormir jusqu'à ce qu'il ait mangé suffisamment de fois.
     */
    @Override
    public void run() {
        try {
            while (numberOfMeals == -1 || meals < numberOfMeals) {
                think();
                forks.pickUp(); // Prend deux fourchettes en utilisant le sémaphore
                eat();
                forks.putDown(); // Libère les fourchettes
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

    // Simule le repas du philosophe
    private void eat() throws InterruptedException {
        System.out.println(System.currentTimeMillis() + " " + id + " est en train de manger");
        meals++;
        TimeUnit.MILLISECONDS.sleep(timeToEat);
    }

    // Simule le sommeil du philosophe
    private void sleep() throws InterruptedException {
        System.out.println(System.currentTimeMillis() + " " + id + " est en train de dormir");
        TimeUnit.MILLISECONDS.sleep(timeToSleep);
    }
}
