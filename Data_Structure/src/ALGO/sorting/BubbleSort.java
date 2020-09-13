package ALGO.sorting;

import java.util.Scanner;

public class BubbleSort {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the size of array");
    int n = in.nextInt();
    int arr[] = new int[n];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = in.nextInt();
    }
    BubbleSort bs = new BubbleSort();
    bs.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public void sort(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }
}
