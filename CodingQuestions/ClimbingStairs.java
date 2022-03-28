package com.company;

//DYnamic Programming Question
// Cache the result of the decision tree using memoization
class Solution{
    public int ClimbingStairs(int n)
    {
        int [] dp = new int[]{};  // stores how many ways to clime 1,2 steps
        // Use a bottom up approach
        // and start with the base case

        int one  = 1;
        int two  = 1;

        // COntinously cache the result
        for(int i = 0; i < n-1; i++)
        {
            int temp = one;
            one = one + two;
            two = temp;
        }


        return one;

    }
}

public class Main {

    public static void main(String[] args) {

        Solution sol = new Solution();

        int val = sol.ClimbingStairs(5);
	// write your code here
    }
}
