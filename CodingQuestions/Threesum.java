package com.company;

import java.util.*;
class ThreeSum{
    public List<List<Integer>> threesum(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> output_arr = new LinkedList();

        for(int i = 0; i < nums.length-2; i++)
        {
            // check that there are no duplicates in the initial list
            if(i == 0 || (i > 0) && nums[i] != nums[i-1])
            {
                int l = i+1; // offset from initial i;
                int r = nums.length -1;
                // compute the target sum from two sum
                int sum = 0 - nums[i];

                // run two sum
                while(l < r)
                {
                    if(nums[l] + nums[r] == sum)
                    {
                        output_arr.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        // avoid duplicates for l and r
                        while (l < r && nums[l] == nums[l+1])
                        {
                            l++;
                        }

                        while (l < r && nums[r] == nums[r-1])
                        {
                            r--;
                        }
                        // increment l and decrease r as per twosum sorted
                        l++;
                        r--;
                    }

                    else if(l+r > sum)
                    {
                        r--;
                    }
                    else if(l+r < sum)
                    {
                        l++;
                    }
                }
            }
        }

        return output_arr;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
