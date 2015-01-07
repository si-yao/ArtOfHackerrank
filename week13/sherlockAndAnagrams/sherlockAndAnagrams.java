import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Brute Force. It's possible because the input is not very big.
But also, I think we can sovle this problem by DP.
*/
public class SherlockAndAnagrams {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.valueOf(in.nextLine());
        for(int i=0; i<t; ++i){
            String line = in.nextLine();
            char[] s = new char[line.length()];
            for(int j=0; j<line.length(); ++j){
                s[j] = line.charAt(j);
            }
            System.out.println(pairs(s));
        }
    }
    
    public static int pairs(char[] s){
        int count = 0;
        for(int i=1; i<=s.length-1; ++i){
            for(int j=0; j<s.length-i; ++j){
                for(int k=j+1; k<s.length-i+1; ++k){
                    if(isAnag(s, j, j+i-1, k, k+i-1)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    public static boolean isAnag(char[] s, int low1, int high1, int low2, int high2){
        if(high1-low1 != high2-low2){
            return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=low1; i<=high1; ++i){
            char ch = s[i];
            if(!map.containsKey(ch)){
                map.put(ch, 0);
            }
            map.put(ch, map.get(ch)+1);
        }
        for(int i=low2; i<=high2; ++i){
            char ch = s[i];
            if(!map.containsKey(ch) || map.get(ch)<=0) {
                return false;
            } else {
                map.put(ch, map.get(ch)-1);
            }
        }
        return true;   
    }
}
