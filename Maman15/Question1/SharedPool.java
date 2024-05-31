package Question1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class SharedPool {
    private Queue<Integer> pool = new LinkedList<>();

    private final int MAX_RANDOM_NUM = 100;

    public SharedPool(int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            pool.add(random.nextInt(MAX_RANDOM_NUM) + 1);
        }
    }

    public synchronized int[] getTwoElements() {
        if (pool.size() < 2) {
            return null;
        }
        int[] elements = new int[2];
        elements[0] = pool.poll();
        elements[1] = pool.poll();
        System.out.println("elements returned: " + Arrays.toString(elements));
        return elements;
    }

    public synchronized void addElement(int element) {
        pool.add(element);
        System.out.println("added element: " + element);
        System.out.println("current array: " + pool.toString());
        notifyAll();
    }

    public synchronized int getFinalSum() {
        while (pool.size() != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return pool.peek();
    }

    public synchronized Queue<Integer> getPool(){
        return pool;
    }
}
