package multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author FLIGHT
 * @date 29.06.2023
 */
public class FooBar {

  private final int n;

  private final Semaphore fooSemaphore = new Semaphore(1);
  private final Semaphore barSemaphore = new Semaphore(0);

  public FooBar(int n) {
    this.n = n;
  }

  public void foo(Runnable printFoo) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      fooSemaphore.acquire();
      printFoo.run();
      barSemaphore.release();
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      barSemaphore.acquire();
      printBar.run();
      fooSemaphore.release();
    }
  }
}
