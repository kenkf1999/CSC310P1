/*
author: Kenneth Fugate
course: CSC 310
date: October 26, 2018
purpose: Radix Sort
note: Code based on code from https://www.geeksforgeeks.org/radix-sort/
*/

import java.util.Queue;
import java.util.LinkedList;
public class Project1Question1 {
 
    static int findMax(int a[], int n){ //find the max in the array
     
        int max = a[0]; 
        for (int i = 1; i < n; i++) 
            if (a[i] > max) 
                max = a[i]; 
        return max; 
    } 
  
    static void countSort(int a[], int n, int i){  //count the sorting in the array depending
                                                  // on the digit store in i
        int b[] = new int[n]; //output array to hold results
        int j; 
        int cnt[] = new int[10];  
  
        for (j = 0; j < n; j++)  // count amount of occurences in the cnt array
            cnt[ (a[j]/i)%10 ]++; 
  
        for (j = 1; j < 10; j++) //change cnt[j] to contain position of digit in output
            cnt[j] += cnt[j - 1]; 
  
        
        for (j = n - 1; j >= 0; j--) { //fill up output array
         
            b[cnt[ (a[j]/i)%10 ] - 1] = a[j]; 
            cnt[ (a[j]/i)%10 ]--; 
        } 
  
        for (j = 0; j < n; j++) //copy output to original array
            a[j] = b[j]; 
    } 
   
    static void radixsort(int a[], int n) {//initializes the other methods to complete radix sort
      
        int m = findMax(a, n); //find max number to count number of digits
  
        for (int i = 1; m/i > 0; i *= 10) //pass this instead of digit number
            countSort(a, n, i); 
    } 
  
  
    public static void main(String[] args) {
        Queue q = new LinkedList(); //use a queue for output
        int a[] = {35, 53, 55, 33, 52, 32, 25};
        int n = a.length; 
        radixsort(a, n); 
        for(int i = 0; i < a.length; i++)
            q.add(a[i]);
        System.out.println(q);
    }
}