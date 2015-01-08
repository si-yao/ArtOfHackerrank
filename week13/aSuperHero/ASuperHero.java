import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
I knew that I should use DP. But the first submission get WA!
Becase I just pick an optimized sub path among level k...N.
It is DP + Greedy!!! Greedy is hard to be right!!!
So we should calculate and store optimized sub path starting at each element of level k among level k...N!
Then pick the smallest path among level 0!
*/
public class ASuperHero {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i<t; ++i){
            int N = in.nextInt();
            int M = in.nextInt();
            int[][] P = new int[N][M];
            int[][] B = new int[N][M];
            for(int j=0; j<N; ++j){
                for(int k=0; k<M; ++k){
                    P[j][k] = in.nextInt();
                }
            }
            for(int j=0; j<N; ++j){
                for(int k=0; k<M; ++k){
                    B[j][k] = in.nextInt();   
                }
            }
            int min = minBullet(P, B, N, M);
            System.out.println(min);
        }
    }
    public static int minBullet(int[][] P, int[][] B, int N, int M){
        int[][] A = new int[N][M];
        for(int i=N-1; i>=0; --i){
            for(int j=0; j<M; ++j){
                if(i == N-1) {
                    A[i][j] = P[i][j];
                    continue;
                }
                int tmp;
                int p = P[i][j];
                int b = B[i][j];
                A[i][j] = Integer.MAX_VALUE;
                for(int k=0; k<M; ++k){
                    tmp = p + A[i+1][k] - Math.min(P[i+1][k], b);
                    A[i][j] = Math.min(A[i][j], tmp);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<M; ++i){
            min = Math.min(min, A[0][i]);
        }
        return min;
    }
}
