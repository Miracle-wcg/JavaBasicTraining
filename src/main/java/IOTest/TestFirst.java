package IOTest;

import java.io.UnsupportedEncodingException;

/**
 * @author chengangw
 * @date 29/9/2017 4:38 PM
 */
public class TestFirst {
    public static void main(String[] args) {
        try {
//            System.out.println("â€¢");

            // Convert from Unicode to UTF-8
            String string = "ï?¶";
            byte[] utf8 = string.getBytes("ISO-8859-6");

            // Convert from UTF-8 to Unicode
//            string = new String(utf8, "UTF-8");
            string = new String(utf8, "UTF-8");
            System.out.println(string);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
