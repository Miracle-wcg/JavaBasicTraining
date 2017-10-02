package IOTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chengangw
 * @date 27/9/2017 4:38 PM
 */
public class ReadFileThree {
    public static void main(String[] args) {
        System.out.println("Start at:" + new Date());
        double startMem = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
        System.out.println(startMem + "KB");

        long startDt = System.currentTimeMillis();
        FileReader in = null;
        FileReader resultIn = null;
        List<ContactTO> origICMSList = new ArrayList<ContactTO>();
        List<ContactTO> origResultList = new ArrayList<ContactTO>();
        List<ContactTO> resultList = new ArrayList<ContactTO>();
        try {
//            in = new FileReader("D:\\WDA ILP\\Compare Data\\ICMS Sep30\\ORGANIZATION\\copy\\Org Contact Number.csv");
            in = new FileReader("D:\\WDA ILP\\Compare Data\\ICMS Sep30\\ORGANIZATION\\copy\\Org Contact Number.csv");
            BufferedReader br = new BufferedReader(in);

            String line;
            while ((line = br.readLine()) != null) {
//                System.out.println(line.trim());
                String lineStr = line.trim();
                String[] valArray = lineStr.split(",");
                ContactTO contactTO = new ContactTO();
                for (int i = 0; i < valArray.length; i++) {
                    if (i == 0) {
                        contactTO.setUen(valArray[0]);
                    }
                    if (i == 1) {
                        contactTO.setExtId(valArray[1]);
                    }
                    if (i == 2) {
                        contactTO.setTypeId(valArray[2]);
                    }
                    if (i == 3) {
                        contactTO.setType(valArray[3]);
                    }
                    if (i == 4) {
                        contactTO.setCountryCode(valArray[4]);
                    }
                    if (i == 5) {
                        contactTO.setNam(valArray[5]);
                    }
                    if (i == 6) {
                        contactTO.setTelepNo(valArray[6]);
                    }
                }
                origICMSList.add(contactTO);
            }
            in.close();


            resultIn = new FileReader("D:\\WDA ILP\\Compare Data\\ICMS Sep30\\ORGANIZATION\\copy\\Oct 01\\org_cont_num.txt");
            BufferedReader testBr = new BufferedReader(resultIn);

            String bline;
            while ((bline = testBr.readLine()) != null) {
//                System.out.println(bline.trim());
                String lineStr = bline.trim();
                String[] valArray = lineStr.split(",");
                ContactTO contactTO = new ContactTO();
                for (int i = 0; i < valArray.length; i++) {
                    if (i == 0) {
                        contactTO.setUen(valArray[0].trim());
                    }
                    if (i == 1) {
                        contactTO.setTypeId(valArray[1].trim());
                    }
                    if (i == 2) {
                        contactTO.setType(valArray[2].trim());
                    }
                    if (i == 3) {
                        contactTO.setCountryCode(valArray[3].trim());
                    }
                    if (i == 4) {
                        contactTO.setNam(valArray[4].trim());
                    }
                    if (i == 5) {
                        contactTO.setTelepNo(valArray[5].trim());
                    }
                }
                origResultList.add(contactTO);
            }
            resultIn.close();

            for (ContactTO restTo : origResultList) {
                for (ContactTO icmsTO : origICMSList) {
                    if (icmsTO.getUen() != null && icmsTO.getTelepNo() != null
                            && restTo.getUen() != null && restTo.getTelepNo() != null
                            && icmsTO.getUen().equalsIgnoreCase(restTo.getUen()) && icmsTO.getTelepNo().equalsIgnoreCase(restTo.getTelepNo())) {
                        resultList.add(icmsTO);
                        break;
                    }

                    if(icmsTO.getUen() != null && icmsTO.getTelepNo() == null
                            && restTo.getUen() != null && restTo.getTelepNo() == null
                            && icmsTO.getUen().equalsIgnoreCase(restTo.getUen())){
                        resultList.add(icmsTO);
                        break;
                    }
                }
            }

            File fout = new File("D:\\WDA ILP\\Compare Data\\ICMS Sep30\\ORGANIZATION\\copy\\Oct 01\\org_cont_num_out.csv");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (ContactTO contactTO : resultList) {
                bw.write(contactTO.getUen()+","+contactTO.getExtId());
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


}
