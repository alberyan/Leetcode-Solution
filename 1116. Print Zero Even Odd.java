import java.util.concurrent.*;
class ZeroEvenOdd {
    private int n;
    Semaphore runZero, runOdd, runEven;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        runZero = new Semaphore(0);
        runOdd = new Semaphore(0);
        runEven = new Semaphore(0);
        runZero.release();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i++){
            runZero.acquire();
            printNumber.accept(0);
            if (i % 2 == 1) runOdd.release();
            else runEven.release();
        }
        
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2){
            runEven.acquire();
            printNumber.accept(i);
            runZero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2){
            runOdd.acquire();
            printNumber.accept(i);
            runZero.release();
        }
    }
}

// Runtime: 4 ms, faster than 100.00% of Java online submissions for Print Zero Even Odd.
// Memory Usage: 35.9 MB, less than 100.00% of Java online submissions for Print Zero Even Odd.