import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private Semaphore fizzSema, buzzSema, fizzbuzzSema, numberSema;

    public FizzBuzz(int n) {
        this.n = n;
        this.fizzSema = new Semaphore(0);
        this.buzzSema = new Semaphore(0);
        this.fizzbuzzSema = new Semaphore(0);
        this.numberSema = new Semaphore(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                fizzSema.acquire();
                printFizz.run();
                numberSema.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                buzzSema.acquire();
                printBuzz.run();
                numberSema.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            fizzbuzzSema.acquire();
            printFizzBuzz.run();
            numberSema.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            numberSema.acquire();
            if (i % 3 == 0 && i % 5 == 0) {
                fizzbuzzSema.release();
            } else if (i % 3 == 0) {
                fizzSema.release();
            } else if (i % 5 == 0) {
                buzzSema.release();
            } else {
                printNumber.accept(i);
                numberSema.release();
            }
        }
    }
}