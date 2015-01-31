import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
URL: https://www.hackerrank.com/challenges/find-median
Selection algorithm
*/
public class FindTheMedian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int i=0; i<n; ++i){
            A[i] = in.nextInt();
        }
        int k = (n+1)/2;
        int result = selectK(A, 0, n-1, k);
        System.out.println(result);
    }
    public static int selectK(int[] A, int low, int high, int k){
        int len = high - low + 1;
        int mid = partition(A, low, high);
        if(mid-low+1 == k) return A[mid];
        //MADE BUG HERE: CANNOT BE mid-low > k
        if(mid-low+1 > k) return selectK(A, low, mid-1, k);
        else return selectK(A, mid+1, high, k-mid+low-1);
    }
    public static int partition(int[] A, int low, int high){
        if(low == high) return low;
        int pvt = A[high];
        int wall, left;
        wall = low;
        while(wall<high && A[wall]<pvt){
            wall ++;
        }
        left = wall+1;
        while(left < high){
            if(A[left] < pvt){
                int tmp = A[wall];
                A[wall] = A[left];
                A[left] = tmp;
                wall++;
            }
            left++;
        }
        A[high] = A[wall];
        A[wall] = pvt;
        return wall;
    }
}
