package hust.soict.hedspi.garbage;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class GarbageCreator {
    public static void main(String[] args) {
        File x = new File("/home/vivi/IdeaProjects/OtherProjects/untitled/src/hust/soict/hedspi/garbage/test.txt");
        long start = System.currentTimeMillis();
        Scanner sc = null;
        try {
            sc = new Scanner(x);
            String content = "";
            while(sc.hasNextLine()) {
                content += sc.nextLine() + "\n";
            }
            System.out.println(System.currentTimeMillis() - start);
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}