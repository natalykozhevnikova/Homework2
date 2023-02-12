
package Homework2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;


public class Task2 {
    public static int[] randomArr() {
        Random rand = new Random();
        int arr[] = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000);
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        return arr;
    }

    public static int[] babblSort(int arr[]) throws IOException {
        Logger logger = Logger.getLogger(Task2.class.getName());
        FileHandler fh = new FileHandler("Task2_logger.txt");
        logger.addHandler(fh);
        logger.info("Тестовое логирование");



        int temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            logger.info(Arrays.toString(arr));
        }
        return arr;

    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) throws IOException {

        print(babblSort(randomArr()));
    }

}

