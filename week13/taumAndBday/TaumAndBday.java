import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Solution is simple.
*/
public class TaumAndBday {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i=0; i<t; ++i){
            long b = scan.nextLong();
            long w = scan.nextLong();
            long x = scan.nextLong();
            long y = scan.nextLong();
            long z = scan.nextLong();
            System.out.println(way(b,w,x,y,z));
        }
    }
    public static long way(long b, long w, long x, long y, long z){
        long pb = Math.min(x, y+z);
        long pw = Math.min(y, x+z);
        return b*pb + w*pw;
    }
}
