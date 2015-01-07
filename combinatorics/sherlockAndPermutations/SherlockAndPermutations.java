import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
https://www.hackerrank.com/challenges/sherlock-and-permutations
Use DP. The simple idea is calculating by math equation, but it will overflow and hard to mod 10^9+7.
So, use DP in stead. As DP only use addition, it is easy to mod 10^9+7.
*/
public class SherlockAndPermutations {

    public static void main(String[] args) {
        int[][] A = new int[1001][1001];
        for(int i=0; i<1001; ++i){
            A[i][0] = A[0][i] = 1;
        }
        for(int i=1; i<1001; ++i){
            for(int j=1; j<1001; ++j){
                A[i][j] = (int)(((long)A[i-1][j] + (long)A[i][j-1])%(1000000000L + 7));
            }
        }
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i<t; ++i){
            int N = in.nextInt();
            int M = in.nextInt() - 1;
            System.out.println(A[M][N]);
        }
    }
}
