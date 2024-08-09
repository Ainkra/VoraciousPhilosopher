package libs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Fork représente une fourchette dans la première partie du problème des philosophes,
 * gérée par un ReentrantLock pour synchroniser l'accès entre les philosophes.
 */
public class Fork {
    private final ReentrantLock lock = new ReentrantLock(); // Verrou pour synchroniser l'accès à la fourchette

    /**
     * Le philosophe prend la fourchette (acquiert le verrou).
     */
    public void pickUp() {
        lock.lock();
    }

    /**
     * Le philosophe repose la fourchette (libère le verrou).
     */
    public void putDown() {
        lock.unlock();
    }
}
