package com.company;

// Requires a Runtime Complexity of O(log(m+n))
// Start thinking of algorithms that have these kind of runtime complexity
// Median could be the middle number in the odd case
// In the even case, median is the middle numbers divided 2
// Use Binary Search
class Solution {
    double findMedianSortedArray(int []nums1, int[] nums2)
    {
        // Base Case do binary search on the smallest array
        if(nums2.length < nums1.length )
        {
            findMedianSortedArray(nums2, nums1);
        }

        // Find the length of both arrays
        int n1 = nums1.length;
        int n2 = nums2.length;
        // Maximum number of elements you can choose
        int l = 0, h = n1;

        // Start Binary search
        while(l < h)
        {
            // Where you cut the first and second arrays
            int firstcut = (l + h) / 2; // Cast to an int
            int secondcut = (n1 + n2 + 1) /2 - firstcut;

            int l1, l2, r1, r2;

            l1 = firstcut == 0 ? Integer.MIN_VALUE : nums1[firstcut-1];
            r1 = firstcut == 0? Integer.MAX_VALUE : nums2[firstcut];
            l2 = secondcut == 0 ? Integer.MIN_VALUE : nums2[secondcut-1];
            r2 = secondcut == 0 ? Integer.MAX_VALUE : nums2[secondcut];

            // Check the edges of the arrays
            if(l1 <= r2 && l2 <= r1)
            {
                // Check if the length of the sorted array is even
                if((n1 + n2) %2 == 0)
                {
                    return (Math.max(l1, l2) +  Math.min(r1, r2) ) /2.0;
                }
                // else if the sorted array is odd
                else
                {
                    return Math.max(l1, l2);
                }
            }
            // Adjust the positions of the case above is not met
            else if (l1 < r2)
            {
                h = firstcut -1;
            }
            else
            {
                l = firstcut + 1;
            }

        }

        return 0.0;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
