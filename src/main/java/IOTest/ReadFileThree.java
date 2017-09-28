package IOTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chengangw
 * @date 27/9/2017 4:38 PM
 */
public class ReadFileThree {
    public static void main(String[] args) {
        System.out.println(hasNRIC("iyoiiu,"));
    }


    public static boolean hasUEN(String lineStr) {
        if (lineStr.indexOf(",") > 0) {
            String uen = lineStr.substring(0, lineStr.indexOf(","));
            return isValidUEN(uen);
        }
        return false;
    }

    public static boolean hasNRIC(String lineStr) {
        if (lineStr.indexOf(",") > 0) {
            String uen = lineStr.substring(0, lineStr.indexOf(","));
            return isValidNRIC(uen);
        }
        return false;
    }

    public static boolean isValidNRIC(String nric) {
        if (nric.length() == 9) {
            if (isString(String.valueOf(nric.charAt(0)))
                    && isNumber(String.valueOf(nric.charAt(1)))
                    && isNumber(String.valueOf(nric.charAt(2)))
                    && isNumber(String.valueOf(nric.charAt(3)))
                    && isNumber(String.valueOf(nric.charAt(4)))
                    && isNumber(String.valueOf(nric.charAt(5)))
                    && isNumber(String.valueOf(nric.charAt(6)))
                    && isNumber(String.valueOf(nric.charAt(7)))
                    && isString(String.valueOf(nric.charAt(8)))) {
                return true;
            }

        }

        return false;
    }

    public static boolean isValidUEN(String uen) {
        if (uen.length() >= 10) {
            if (isNumber(uen.substring(0, 9)) && isString(String.valueOf(uen.charAt(9)))) {
                return true;
            }

            if (isString(String.valueOf(uen.charAt(0)))
                    && isNumber(String.valueOf(uen.charAt(1)))
                    && isNumber(String.valueOf(uen.charAt(2)))
                    && isString(String.valueOf(uen.charAt(3)))
                    && isString(String.valueOf(uen.charAt(4)))
                    && isNumber(String.valueOf(uen.charAt(5)))
                    && isNumber(String.valueOf(uen.charAt(6)))
                    && isNumber(String.valueOf(uen.charAt(7)))
                    && isNumber(String.valueOf(uen.charAt(8)))
                    && isString(String.valueOf(uen.charAt(9)))) {
                return true;
            }

        } else if (uen.length() == 9) {
            if (isNumber(uen.substring(0, 8)) && isString(String.valueOf(uen.charAt(8)))) {
                return true;
            }
        }

        return false;
    }

    public static boolean isNumber(String numStr) {
        Pattern numP = Pattern.compile("^\\d+$");
        Matcher numMth = numP.matcher(numStr);
        return numMth.matches();
    }

    public static boolean isString(String str) {
        Pattern strP = Pattern.compile("[a-zA-Z]");
        Matcher strMth = strP.matcher(str);
        return strMth.matches();
    }
}
