package MethodTest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author chengangw
 * @date 11/11/2016 3:18 PM
 */
public class MethodTest {
    public static void main(String[] args) {
//        Date startDt = new Date();
//        Date endDt = new Date();
//        Period period = new Period(startDt, endDt);
//        endDt.setTime(78);
//        System.out.println(sumArray(1,2,3,4));
//        Base64.encode();
//        String description = "Residential care services for children (eg children’s homes, orphanages)";
//        String description1 = "Residential care services for children (eg children's homes, orphanages)";
//        System.out.println(description);
//        System.out.println(description1);
        /*DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd-MM-yyyy kk:mm a");
        String str = "21-12-2016 19:54 PM";
        LocalDateTime localDate = LocalDateTime.parse(str,sdf);
        System.out.println(localDate.format(sdf));
        Date convert = Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(convert);*/

        StringBuilder stringBuilder = new StringBuilder("absac");
        System.out.println(stringBuilder.reverse().toString());
    }

    public static int sumArray(int... arrs) {
        int sum = 0;
        for (int a : arrs) {
            sum += a;
        }
        return sum;
    }
}
