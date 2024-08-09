package libs;

import java.util.concurrent.Semaphore;

/**
 * Forks représente la gestion des fourchettes à l'aide d'un sémaphore.
 * Utilisé dans la deuxième partie pour gérer l'accès concurrent aux fourchettes.
 */
public class Forks {
    private final Semaphore forks; // Sémaphore pour contrôler le nombre de fourchettes disponibles

    /**
     * Constructeur pour Forks.
     *
     * @param numberOfForks Le nombre total de fourchettes disponibles.
     */
    public Forks(int numberOfForks) {
        this.forks = new Semaphore(numberOfForks);
    }

    /**
     * Méthode pour prendre deux fourchettes.
     * Bloque si pas assez de fourchettes sont disponibles.
     * @throws InterruptedException Si le thread est interrompu pendant l'attente.
     */
    public void pickUp() throws InterruptedException {
        forks.acquire(2);
    }

    /**
     * Méthode pour relâcher deux fourchettes.
     */
    public void putDown() {
        forks.release(2);
    }
}
