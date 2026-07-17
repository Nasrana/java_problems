class FooBar {
    private int n;

    // Starts with 1 permit: foo() is allowed to go first
    private final Semaphore fooTurn = new Semaphore(1);
    // Starts locked: bar() must wait until foo() says it's ready
    private final Semaphore barTurn = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // Wait for permission to print "foo"
            fooTurn.acquire();

            printFoo.run();

            // Hand off control to bar()
            barTurn.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // Wait for permission to print "bar"
            barTurn.acquire();

            printBar.run();

            // Hand off control back to foo()
            fooTurn.release();
        }
    }
}