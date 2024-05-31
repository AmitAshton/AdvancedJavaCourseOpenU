package Question1;

public class SumWorker extends Thread {
    private SharedPool pool;

    public SumWorker(SharedPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true) {
            int[] elements = pool.getTwoElements();
            if (elements == null) {
                break;
            }
            int sum = elements[0] + elements[1];
            System.out.println("sum in sumWorker number " + this.getId() + " is: " + sum);
            pool.addElement(sum);
        }
    }
}
