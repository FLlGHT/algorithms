package multithreading;

import java.util.concurrent.Semaphore;

/**
 * @author FLIGHT
 * @date 29.06.2023
 */
public class H2O {

  private final Semaphore hydrogenLock = new Semaphore(2);
  private final Semaphore oxygenLock = new Semaphore(0);

  public H2O() {

  }

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    hydrogenLock.acquire();
    releaseHydrogen.run();
    oxygenLock.release();
  }

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    oxygenLock.acquire(2);
    releaseOxygen.run();
    hydrogenLock.release(2);
  }
}
