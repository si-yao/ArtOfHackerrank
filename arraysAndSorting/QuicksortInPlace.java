import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
URL: https://www.hackerrank.com/challenges/quicksort3
This is a novel quicksort algorithm that I learnt. 
Thanks to https://www.hackerrank.com/challenges/quicksort3/forum/comments/36793
Left-wall algorithm.
Make wall point to the first ele that is greater than pvt.
And move left next to the wall, whenever find a ele less than pvt, then swap wall and left.
And then wall++, left++, continue to find.
wall is gauranteed to point to the first ele that is greater than pvt.
And ele between wall(inclusive) and left is gauranteed to be greater than pvt. 
*/
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int i=0; i<n; ++i){
            A[i] = in.nextInt();
        }
        quicksort(A, 0, n-1);
    }
    public static void quicksort(int[] A, int low, int high){
        if(low >= high) return;
        int mid = partition(A, low, high);
        quicksort(A, low, mid-1);
        quicksort(A, mid+1, high);
    }
    public static int partition(int[] A, int low, int high){
        if(low == high) return low;
        int pvt = A[high];
        int wall, left;
        wall = low;
        while(wall<high && A[wall]<pvt){
            wall++;
        }
        left = wall + 1;
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
        printArray(A);
        return wall;
    }
    public static void printArray(int[] A){
        for(int i=0; i<A.length; ++i){
            System.out.print(A[i]);
            if(i != A.length-1){
                System.out.print(" ");
            } else {
                System.out.print("\n");
            }
        }
    }
}
