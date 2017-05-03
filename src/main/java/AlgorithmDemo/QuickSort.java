package AlgorithmDemo;

import java.util.Arrays;

/**
 * Created by chengangw on 3/5/17.
 */
public class QuickSort {
    int[] arr;

    private void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private void quick_sort_recursive(int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = arr[end];
        int left = start, right = end - 1;
        while (left < right) {
            while (arr[left] <= mid && left < right) {
                left++;
            }
            while (arr[right] >= mid && left < right) {
                right--;
            }
            swap(left, right);
        }
        if (arr[left] >= arr[end]) {
            swap(left, end);
        } else {
            left++;
        }
        quick_sort_recursive(start, left - 1);
        quick_sort_recursive(left + 1, end);
    }

    public void sort(int[] arry) {
        arr = arry;
        quick_sort_recursive(0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arra = {9, 2, 8, 4, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arra);
        System.out.println(Arrays.toString(arra));
    }
}
