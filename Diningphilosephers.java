import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;

class DiningPhilosophers {
    
    private final ReentrantLock[] forks;
    private final Semaphore eatingLimiter;

    public DiningPhilosophers() {
        forks = new ReentrantLock[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
        // Only allow 4 philosophers to attempt eating at once
        eatingLimiter = new Semaphore(4);
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;
        
        eatingLimiter.acquire();
        
        forks[leftFork].lock();
        forks[rightFork].lock();
        
        pickLeftFork.run();
        pickRightFork.run();
        
        eat.run();
        
        putLeftFork.run();
        putRightFork.run();
        
        forks[leftFork].unlock();
        forks[rightFork].unlock();
        
        eatingLimiter.release();
    }
}