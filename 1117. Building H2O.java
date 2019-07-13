import java.util.concurrent.*;
class H2O {
    Semaphore outputting, outputHydrogen, outputOxygen;
    
    public H2O() {
        outputting = new Semaphore(1);
        outputHydrogen = new Semaphore(0);
        outputOxygen = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        //we only "output" when oxygen says so
        outputHydrogen.acquire();
        releaseHydrogen.run();
        outputOxygen.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        //we only output 1 complete set at a time.
        outputting.acquire();
        
        outputHydrogen.release(2);
		releaseOxygen.run();
		//we wait for 2 hydrogens to finish printing
        outputOxygen.acquire(2);
        
        outputting.release();
    }
}

// Runtime: 14 ms, faster than 100.00% of Java online submissions for Building H2O.
// Memory Usage: 37.7 MB, less than 100.00% of Java online submissions for Building H2O.