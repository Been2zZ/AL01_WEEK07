package Invariant;

import java.io.*;

public class TestLoopInvariant  {
    public static void main(String[] args) throws FileNotFoundException  {
        LoopInvariant li = new LoopInvariant();

        File file_a = new File("data07_a.txt");
        File file_b = new File("data07_b.txt");
        int[] A = li.insert(file_a);
        int[] B = li.insert(file_b);

        System.out.println(li.findMidElements(A, B));
    }
}
