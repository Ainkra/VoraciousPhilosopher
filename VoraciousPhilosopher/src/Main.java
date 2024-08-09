import libs.Fork;
import libs.Forks;
import libs.Philosopher;
import libs.SemaPhilo;

/**
 * PARTIE 1
 *
 * Décommenter la section suivante pour exécuter la première partie de la simulation où chaque philosophe
 * utilise des fourchettes protégées par des mutex.
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
//        // Initialisation des fourchettes
//        for (int i = 0; i < numberOfPhilosophers; i++) {
//            forks[i] = new Fork();
//        }
//
//        // Initialisation et démarrage des philosophes
//        for (int i = 0; i < numberOfPhilosophers; i++) {
//            Fork leftFork = forks[i];
//            Fork rightFork = forks[(i + 1) % numberOfPhilosophers];
//
//            philosophers[i] = new Philosopher(i + 1, leftFork, rightFork, timeToDie, timeToEat, timeToSleep, numberOfMeals);
//            philosophers[i].start();
//        }
//
//        // Attente que tous les philosophes aient terminé
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
 *
 * Cette classe Main configure et lance la simulation pour la deuxième partie, où les philosophes
 * utilisent un sémaphore pour gérer les fourchettes. Chaque philosophe est représenté par une
 * instance de SemaPhilo.
 */
public class Main {
    public static void main(String[] args) {
        int numberOfPhilosophers = 6; // Nombre de philosophes et de fourchettes disponibles
        long timeToDie = 1000; // Temps maximal avant qu'un philosophe ne meure s'il ne mange pas
        long timeToEat = 200; // Temps que prend un philosophe pour manger
        long timeToSleep = 100; // Temps que prend un philosophe pour dormir
        int numberOfMeals = 12; // Nombre de repas qu'un philosophe doit prendre avant la fin de la simulation

        // Instancie un sémaphore qui contrôle l'accès aux fourchettes
        Forks forks = new Forks(numberOfPhilosophers);

        // Crée un tableau pour stocker les philosophes (processus)
        SemaPhilo[] semaPhilos = new SemaPhilo[numberOfPhilosophers];

        // Initialise et démarre chaque philosophe
        for (int i = 0; i < numberOfPhilosophers; i++) {
            semaPhilos[i] = new SemaPhilo(i + 1, forks, timeToDie, timeToEat, timeToSleep, numberOfMeals);
            semaPhilos[i].start();
        }

        // Attend que tous les philosophes aient terminé
        for (SemaPhilo semaPhilo : semaPhilos) {
            try {
                semaPhilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
