package Question1;

import java.util.Scanner;
/*
IMPORTANT NOTE:
I added some print statements in the other classes to prove the concurrency:
1. line 18 SumWorker class.
2. line 27 SharedPool class.
3. lines 33-34 SharedPool class.
I thought it might benefit to your testing. you can remove it if its bothering.
Thank you!
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the amount of numbers in the array: ");
        int n = sc.nextInt();

        System.out.println("Please enter the number of threads to sum the array: ");
        int m = sc.nextInt();

        SharedPool pool = new SharedPool(n);
        System.out.println("array is:" + pool.getPool());

        SumWorker[] workers = new SumWorker[m];

        for (int i = 0; i < m; i++) {
            workers[i] = new SumWorker(pool);
        }

        for (int i = 0; i < m; i++) {
            workers[i].start();
        }

        for (int i = 0; i < m; i++) {
            try {
                workers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("The sum of the array is: " + pool.getFinalSum());
    }
}

