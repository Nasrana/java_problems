class Foo {

    // Semaphore starts locked (0 permits) - second() can't run until first() releases it
    private final Semaphore firstDone = new Semaphore(0);
    // Semaphore starts locked (0 permits) - third() can't run until second() releases it
    private final Semaphore secondDone = new Semaphore(0);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // Do the actual work of method first()
        printFirst.run();

        // Signal that first() is done, so second() is now allowed to run
        firstDone.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // Wait here until first() gives the go-ahead
        firstDone.acquire();

        printSecond.run();

        // Signal that second() is done, so third() can now run
        secondDone.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Wait here until second() gives the go-ahead
        secondDone.acquire();

        printThird.run();
    }
}