package AlgorithmDemo;

import java.util.Arrays;

/**
 * Created by chengangw on 19/4/17.
 */
public class MergeSort {

    static int num = 0;

    public static void main(String[] args) {
        int[] a = {10, 3, 9, 2, 199, 18, 25, 67, 23, 55};
        System.out.println("Before sorting:" + Arrays.toString(a));
        sort(a, 0, a.length - 1);
        System.out.println("After sorting:" + Arrays.toString(a));
    }

    private static void sort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(a, left, mid);
        sort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[a.length];
        int r1 = mid + 1;
        int tmpIndex = left;
        int copyIndex = left;
        while (left <= mid && r1 <= right) {
            if (a[left] <= a[r1]) {
                tmp[tmpIndex++] = a[left++];
            } else {
                tmp[tmpIndex++] = a[r1++];
            }
        }

        while (left <= mid) {
            tmp[tmpIndex++] = a[left++];
        }
        while (r1 <= right) {
            tmp[tmpIndex++] = a[r1++];
        }
        System.out.println("This is " + (++num) + " round sort.");
        while (copyIndex <= right) {
            a[copyIndex] = tmp[copyIndex];
            System.out.printf(a[copyIndex] + "\t");
            copyIndex++;
        }
        System.out.println();

    }
}
