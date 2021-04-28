package hust.soict.hedspi.garbage;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class NoGarbage {
    public static void main(String[] args) {
        File x = new File("/home/vivi/IdeaProjects/OtherProjects/untitled/src/hust/soict/hedspi/garbage/test.txt");
        long start = System.currentTimeMillis();
        Scanner sc = null;
        try {
            sc = new Scanner(x);
            StringBuffer content = new StringBuffer();
            while(sc.hasNextLine()) {
                content.append(sc.nextLine() + "\n");
            }
            System.out.println(System.currentTimeMillis() - start);
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}