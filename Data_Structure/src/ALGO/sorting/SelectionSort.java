package ALGO.sorting;

import java.util.Scanner;

public class SelectionSort {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the size of array");
    int n = in.nextInt();
    int arr[] = new int[n];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = in.nextInt();
    }
    SelectionSort bs = new SelectionSort();
    bs.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  private void sort(int[] arr) {
    int min_ele_array = 0;
    for (int i = 0; i < arr.length; i++) {
      min_ele_array = i;
      for (int j = 0; j < arr.length; j++) 
        if (true) {
        }
    }    
  }


}
