package org.example;

import java.util.Arrays;
import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(100_000);

        int[] arrBubble = Arrays.copyOf(arr, arr.length);
        long startBubble = System.currentTimeMillis();
        sortBubble(arrBubble);
        long durationBubble = System.currentTimeMillis() - startBubble;
        System.out.println("Пузырьковая сортировка " + durationBubble + "ms");

        int[] arrSelection = Arrays.copyOf(arr, arr.length);
        long startSelection = System.currentTimeMillis();
        sortSelection(arrSelection);
        long durationSelection = System.currentTimeMillis() - startSelection;
        System.out.println("Сортировка выбором " + durationSelection + "ms");

        int[] arrInsertion = Arrays.copyOf(arr, arr.length);
        long staetInsertion = System.currentTimeMillis();
        sortInsertion(arrInsertion);
        long durationInsertion = System.currentTimeMillis() - staetInsertion;
        System.out.println("Сортировка вставкой " + durationInsertion + "ms");
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100_000);
        }
        return arr;
    }

    public static void swapElements(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
