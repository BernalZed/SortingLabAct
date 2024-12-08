
package labactsortingalgoandimplementation;

import java.util.Arrays;
import java.util.Random;

class SortingLab {
    public static void bubbleSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            double temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(double[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            double key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static boolean isSorted(double[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(double[] arr) {
        for (double num : arr) {
            System.out.printf("%.4f\n", num); 
        }
    }

    public static double[] generateRandomArray(int size) {
        Random rand = new Random(42);
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextDouble() * 1000.0;
        }
        return array;
    }
}

public class LabActSortingAlgoandImplementation {
    public static void main(String[] args) {
        double[] data = SortingLab.generateRandomArray(100);

        double[] bubbleSorted = Arrays.copyOf(data, data.length);
        double[] selectionSorted = Arrays.copyOf(data, data.length);
        double[] insertionSorted = Arrays.copyOf(data, data.length);

        long startTime = System.nanoTime();
        SortingLab.bubbleSort(bubbleSorted);
        long endTime = System.nanoTime();
        long bubbleSortTime = endTime - startTime;
        System.out.println("Bubble Sort Result:");
        SortingLab.printArray(bubbleSorted);
        System.out.println("Bubble Sort Time (ms): " + bubbleSortTime / 1000000.0);

        startTime = System.nanoTime();
        SortingLab.selectionSort(selectionSorted);
        endTime = System.nanoTime();
        long selectionSortTime = endTime - startTime;
        System.out.println("\nSelection Sort Result:");
        SortingLab.printArray(selectionSorted);
        System.out.println("Selection Sort Time (ms): " + selectionSortTime / 1000000.0);

        startTime = System.nanoTime();
        SortingLab.insertionSort(insertionSorted);
        endTime = System.nanoTime();
        long insertionSortTime = endTime - startTime;
        System.out.println("\nInsertion Sort Result:");
        SortingLab.printArray(insertionSorted);
        System.out.println("Insertion Sort Time (ms): " + insertionSortTime / 1000000.0);

        System.out.println("\nVerification:");
        System.out.println("Bubble Sort is Correct: " + SortingLab.isSorted(bubbleSorted));
        System.out.println("Selection Sort is Correct: " + SortingLab.isSorted(selectionSorted));
        System.out.println("Insertion Sort is Correct: " + SortingLab.isSorted(insertionSorted));
    }
}
