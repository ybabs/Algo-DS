package com.company;

// Two pointer solution
class Solution{
    public int minSubArrayLen(int s, int [] nums)
    {
        int res = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;

        int curSum = 0;

        for(int i = 0; i < nums.length; i++)
        {
            curSum +=nums[i];

            while(curSum >= s)
            {
                // Find the current minimum subarray
                res  = Math.min(res, i+1-l);

                // decrement running sum by value of the left pointer
                curSum -= nums[l];

                // increment left pointer
                l++;
            }
        }

        return (res != Integer.MAX_VALUE) ? res : 0;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
