package com.company;

// Solve this in O(n)
// Three loops
// Create an array showing multiplication going forward
// Create another showing multiplication going backward
// Multiply both arrays together
class Solution
{
    public int [] productExceptSelf(int [] nums)
    {
        int N = nums.length;

        int [] left_product = new int[N];
        int [] right_product = new int[N];

        int [] output = new  int [N];

        // Left product will contain the product of all the elements
        // to the left of the current element iterating through the array

        // Assign 1 to the first element of the left product
        left_product[0] = 1;
        for(int i = 1; i < N; i++)
        {
            left_product[i] = nums[i-1] * left_product[i-1];
        }

        right_product[N-1] = 1;
        for(int i = N-2; i>=0; i--)
        {
            right_product[i] = nums[i+1] * right_product[i+1];
        }

        for(int i = 0; i < N; i++)
        {
            output[i] = left_product[i] * right_product[i];
        }

        return output;
    }
}


public class Main {

    public static void main(String[] args) {

        Solution sol = new Solution();

        int [] nums = {1,2,3,4};

        int [] output = sol.productExceptSelf(nums);
	// write your code here
    }
}
