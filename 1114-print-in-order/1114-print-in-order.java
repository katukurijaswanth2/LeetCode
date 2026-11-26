
class Foo {

    private int state = 0;

    public Foo() {
        
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        
        printFirst.run();
        state = 1;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        
        while (state < 1) {
            wait();
        }

        printSecond.run();
        state = 2;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        
        while (state < 2) {
            wait();
        }

        printThird.run();
    }
}
