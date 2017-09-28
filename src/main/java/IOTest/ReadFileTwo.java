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
public class ReadFileTwo {
    public static void main(String[] args) {
        System.out.println("Start at:" + new Date());
        double startMem = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
        System.out.println(startMem + "KB");

        long startDt = System.currentTimeMillis();
        FileReader in = null;
        List<String> origList = new ArrayList<String>();
        List<String> combineList = new ArrayList<String>();
        try {
//            in = new FileReader("D:\\WDA ILP\\IND ORG Reconciliation\\ICMS 16 Sep Files\\Employment\\ICMS-JOB-TITLE.txt");
            in = new FileReader("D:\\WDA ILP\\Compare Data\\IND_employment\\IND_JOB_TITLE.txt");
            BufferedReader br = new BufferedReader(in);

            String line;
            while ((line = br.readLine()) != null) {
//                System.out.println(line.trim());
//                System.out.println(line.indexOf(","));
                origList.add(line.trim());
            }
            in.close();
            String wholeStr = "";
            for (int i = 0; i < origList.size(); i++) {
                String val = origList.get(i);
                if (i == 0) {
                    wholeStr = val;
                } else {
                    if (hasNRIC(val)) {
//                        System.out.println(wholeStr);
                        combineList.add(wholeStr);
                        wholeStr = "";
                        wholeStr = val;
                    } else {
                        wholeStr = wholeStr + val;
                    }
                }
                if (i == origList.size() - 1) {
//                    System.out.println(wholeStr);
                    combineList.add(wholeStr.toString());
                }
            }

//            File fout = new File("D:\\WDA ILP\\IND ORG Reconciliation\\ICMS 16 Sep Files\\Employment\\ICMS-JOB-TITLE_out.txt");
            File fout = new File("D:\\WDA ILP\\Compare Data\\IND_employment\\IND_JOB_TITLE_out.txt");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (String lineVal : combineList) {
                bw.write(lineVal);
                bw.newLine();
            }

            bw.close();

            long duringDt = System.currentTimeMillis() - startDt;
            System.out.println("End at:" + new Date());

            double endMem = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
            System.out.println(endMem + "KB");

            System.out.println("Time takes :" + duringDt);
            System.out.println("Memory takes :" + (endMem - startMem) + "KB");
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public static boolean hasUEN(String lineStr) {
        if (lineStr.indexOf(",") > 0) {
            String uen = lineStr.substring(0, lineStr.indexOf(","));
            return isValidUEN(uen);
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
