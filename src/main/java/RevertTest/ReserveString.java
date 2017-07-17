package RevertTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author chengangw
 * @date 17/7/2017 6:06 PM
 */
public class ReserveString {
    public void reserveStringFirst() {
        String input = "";
        System.out.println("Enter the input string");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            input = br.readLine();
            char[] try1 = input.toCharArray();
            for (int i = try1.length - 1; i >= 0; i--)
                System.out.print(try1[i]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reserveStringTwo() {
        String input = "AliveisAwesome";
        StringBuilder input1 = new StringBuilder();
        input1.append(input);
        input1 = input1.reverse();
        for (int i = 0; i < input1.length(); i++) {
            System.out.print(input1.charAt(i));
        }
    }

    public void reserveStringThree() {
        String input = "Be in present";
        char[] temparray = input.toCharArray();
        int left, right = 0;
        right = temparray.length - 1;
        for (left = 0; left < right; left++, right--) {
            // Swap values of left and right
            char temp = temparray[left];
            temparray[left] = temparray[right];
            temparray[right] = temp;
        }
        for (char c : temparray) {
            System.out.print(c);
        }
        System.out.println();
    }

    public void reserveStringFour() {
        String input = "Be in present";
        char[] hello = input.toCharArray();
        List<Character> trial1 = new LinkedList<Character>();
        for (char c : hello) {
            trial1.add(c);
        }
        Collections.reverse(trial1);
        ListIterator li = trial1.listIterator();
        while (li.hasNext()) {
            System.out.print(li.next());
        }
    }

    public void reserveStringFive() {
        String input = "Be in present";
        byte[] strAsByteArray = input.getBytes();
        byte[] result = new byte[strAsByteArray.length];

        for (int i = 0; i < strAsByteArray.length; i++) {
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
        }
        System.out.println(new String(result));
    }
}
