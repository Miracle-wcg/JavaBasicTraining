package MagicSqureOdd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengangw
 * @date 21/4/2017 2:17 PM
 */
public class CombineArrayFirst {

    public static List resultArr = new ArrayList();

    public void combine(int[] a, int n) {

        if (null == a || a.length == 0 || n <= 0 || n > a.length)
            return;

        int[] b = new int[n];
        getCombination(a, n, 0, b, 0);
    }

    private void getCombination(int[] a, int n, int begin, int[] b, int index) {

        if (n == 0) {
            int res = 0;
            for (int i = 0; i < index; i++) {
                if (i == 0) {
                    res = b[i];
                } else {
                    res = res * b[i];
                }
            }
            resultArr.add(res);
            return;
        }

        for (int i = begin; i < a.length; i++) {
            b[index] = a[i];
            getCombination(a, n - 1, i + 1, b, index + 1);
        }

    }

    public static void main(String[] args) {

        CombineArrayFirst robot = new CombineArrayFirst();

        int[] a = {3, 2, 4, 5, 6};
        int n = a.length - 1;
        robot.combine(a, n);
        System.out.println(resultArr.toString());

    }
}
