/*
Given a list of letters and a dictionary containing a list of valid words, generate all arrangements of words from the given letters.
Input Format
First line is a String s, containing the letters you can arrange.
Second line is the number of words (integer n) in the dictionary.
The next n lines contains the dictionary of words (String[] d). One word per line.
Constraints
1 <= s <= 7
1 <= n <= 100
1<= d[i].length() <= 7
you should assume all characters are lowercase a-z.
Output Format
Output the complete list of words found in one line with each word separated by a space.
Sample Input 0
cfhat
10
a
at
bat
cat
hat
kite
lion
that
yellow
zebra
Sample Output 0
a at cat hat
Explanation 0
the four words that are output all appear in our 10 word dictionary.
Note: you can create other words, but because they are not in our dictionary they are not added to the list - e.g. chat
Also note: the words are output in lexigraphical order - in the same order as they would appear in a dictionary. You may want to generate a list and sort it before displaying.
Also note: the number of letters we have to work with is small enough that all our promising decision needs to do is make sure we don't repeat the same letter more than once.
An additional promising check could be whether or not any words in our dictionary begin with the word we are generating.
*/

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
