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
public class ReadFile {
    public static void main(String[] args) {
        System.out.println("Start at:" + new Date());
        double startMem = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
        System.out.println(startMem + "KB");
        long startDt = System.currentTimeMillis();

        System.out.println("**********Read Start***********");
        FileReader in = null;
        List<String> origList = new ArrayList<String>();
        List<String> combineList = new ArrayList<String>();
        try {
            in = new FileReader("D:\\WDA ILP\\Master About Us\\ICMS.txt");
            BufferedReader br = new BufferedReader(in);

            String line;
            while ((line = br.readLine()) != null) {
//                System.out.println(line.trim());
//                System.out.println(line.indexOf(","));
                origList.add(line.trim());
            }
            in.close();
            StringBuilder wholeStr = new StringBuilder();
            for (int i = 0; i < origList.size(); i++) {
                String val = origList.get(i);
                if (i == 0) {
                    wholeStr.append(val);
                } else {
                    if (hasUEN(val)) {
//                        System.out.println(wholeStr);
                        combineList.add(wholeStr.toString());
                        wholeStr.setLength(0);
                        wholeStr.append(val);
                    } else {
                        wholeStr.append(val);
                    }
                }
                if (i == origList.size() - 1) {
//                    System.out.println(wholeStr);
                    combineList.add(wholeStr.toString());
                }
            }

            long readEndDt = System.currentTimeMillis() - startDt;
            System.out.println("Read end at:" + new Date());
            System.out.println("Read took:" + readEndDt);
            double readEndMem = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
            System.out.println("Read memory took:" + (readEndMem - startMem) + "KB");
            System.out.println("**********Read End***********");

            System.out.println("**********Write Start***********");
            long writeStartDt = System.currentTimeMillis();

            File fout = new File("D:\\test_out.txt");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for (String lineVal : combineList) {
                bw.write(lineVal);
                bw.newLine();
            }
            bw.close();

            long writeEndDt = System.currentTimeMillis() - writeStartDt;
            System.out.println("Read end at:" + new Date());
            System.out.println("Read took:" + readEndDt);
            double writeEndMem = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
            System.out.println("Read memory took:" + (readEndMem - startMem) + "KB");
            System.out.println("**********Write End***********");

            long duringDt = System.currentTimeMillis() - startDt;
            System.out.println("End at:" + new Date());
            double endMem = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
            System.out.println(endMem + "KB");

            System.out.println("Total time took:" + duringDt);
            System.out.println("Total memory took:" + (endMem - startMem) + "KB");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
