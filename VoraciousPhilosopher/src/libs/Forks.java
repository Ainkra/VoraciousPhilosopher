package libs;

import java.util.concurrent.Semaphore;

public class Forks {
    private final Semaphore forks;

    public Forks(int numberOfForks) {
        this.forks = new Semaphore(numberOfForks);
    }

    public void pickUp() throws InterruptedException {
        forks.acquire(2);
    }

    public void putDown() {
        forks.release(2);
    }
}

