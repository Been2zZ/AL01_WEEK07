package Invariant;

import java.io.*;

public class LoopInvariant {


    public int[] insert(File F) throws FileNotFoundException {
        /** File read & Array insert */
        FileReader fr = new FileReader(F);
        BufferedReader br = new BufferedReader(fr);

        String[] temp = null;

        try {
            String line = "";
            while ((line = br.readLine()) != null) {
                temp = line.split(", ");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println(e);
        }

        int size = temp.length;

        int[] Arr = new int[size];

        for (int i = 0; i < Arr.length; i++)
            Arr[i] = Integer.parseInt(temp[i]);

        return Arr;
    }

    public int findMidElements(int[] a, int[] b) {

        int start_a = 0, start_b = 0;
        int end_a = a.length - 1, end_b = b.length - 1;

        while (end_a - start_a > 1 || end_b - start_b > 1) {
        /** A와 B 배열의 원소가 1보다 큰 경우 아래 문장 계속 실행  */
            int median_a = (start_a + end_a) / 2;
            int median_b = (start_b + end_b) / 2;

            if((end_b - start_b + 1) % 2 == 0) {
                /** 배열 개수가 짝수인 경우 */
                if (a[median_a] > b[median_b]) {
                    end_a = median_a;   start_b = median_b;
                } else {
                    /** B 배열의 마지막 index에 1을 더해 A, B 배열의 크기를 맞춰준다. */
                    start_a = median_a; end_b = median_b + 1;
                }
            } else {
                /** 배열의 개수가 홀수인 경우 */
                if(a[median_a] > b[median_b]) {
                    end_a = median_a;   start_b = median_b;
                } else {
                    start_a = median_a; end_b = median_b;
                }
            }
        }
        return Math.min(a[end_a], b[end_b]);
    }

}
