package com;
// Sort this array in a single pass using a O(n) solution
// Use a two pointer solution for this answer
class Solution
{
    public int[] sort (int [] arr)
    {
        int l = 0;
        int r = arr.length()-1;

        // loop through the array and check
        // if l is not greater than r
        while(l < r)
        {
            if(arr[l] == 1)
            {
                // Swap the position of l and r
                swap(arr[l], arr[r]);
                // decrement r;
                r--;
            }
            // Otherwise, increment the left pointer
            else
            {
                l++;
            }

        }
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
