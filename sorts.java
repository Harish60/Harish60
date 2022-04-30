

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String letters = in.next();
        int n = in.nextInt();
        String[] d = new String[n];
        
        for(int i = 0; i < d.length; i++){
            d[i] = in.next();   
        }
        
        for(int i = 0; i < d.length; i++){
            scrabble(letters, d[i]);
        }
    }
    
    public static String scrabble(String s, String s2){
        String str = alpha(s);
        char[] charArr1 = str.toCharArray();
        String str2 = alpha(s2);
        char[] charArr2 = str2.toCharArray();
        String strBuilder = "";
        
        for(int i = 0; i < charArr2.length; i++){
            for(int j = 0; j < charArr1.length; j++){
               if(charArr2[i] == charArr1[j]){
                  strBuilder = strBuilder + charArr1[j];
                  charArr1[j] = ' ';
               }
            }
        }
        if(strBuilder.length() == s2.length()){
            System.out.print(s2 + " ");
        }
        return s;
    }
    
    public static String alpha(String in){
        char charAlpha[] = in.toCharArray(); 
        Arrays.sort(charAlpha);  
        return new String(charAlpha);
    }   
}
