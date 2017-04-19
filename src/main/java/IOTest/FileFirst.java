package IOTest;

import java.io.File;

/**
 * Created by chengangw on 28/3/17.
 */
public class FileFirst {

    private static long fileNum = 0;
    private static long folderNum = 0;
    private static long totalStorage = 0;

    private static void loopFileName(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                fileNum++;
                totalStorage += file.length();
                System.out.println("@_@ File: " + file.getName() + ". Including " + file.length() + " bytes.");
            }
            if (file.isDirectory()) {
                folderNum++;
                System.out.println("*_* Folder: " + file.getName());
                File[] files = file.listFiles();
                for (File f : files) {
                    loopFileName(f);
                }
            }
        } else {
            System.out.println("File is not exist.");
        }

    }

    public static void main(String[] args) {
        String path = "testpa";
        File file = new File(path);
        loopFileName(file);
        System.out.println("******************************************");
        System.out.println("Total files = " + fileNum);
        System.out.println("Total folders = " + (folderNum != 0 ? (folderNum - 1) : folderNum));
        System.out.println("Total bytes = " + totalStorage);
    }
}
