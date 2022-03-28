package com.company;

import java.sql.Array;

// Optimal Solutions
// Both take O(n) time but one takes O(n) space
// while the other takes O(1) space but uses two pointers
class Solution
{
   public int trap(int [] height)
   {
       int total_water = 0;
       int [] max_left = new int[height.length];
       int []max_right = new int[height.length];
       int temp_max_left = 0;
       int temp_max_right = 0;
       // Max Left height
       for (int i = 0; i < height.length; i++)
       {
            if(i == 0)
            {
                max_left[i] = temp_max_left = 0;
            }
            else
            {
                if(height[i-1] > temp_max_left)
                {
                    temp_max_left = height[i-1];
                }
                max_left[i] = temp_max_left;
            }
       }

       // Max Left right
       for (int i = height.length-1; i >=0; i--)
       {
           if(i == height.length-1)
           {
               max_right[i] = temp_max_right = 0;
           }
           else
           {
               if(height[i+1] > temp_max_right)
               {
                   temp_max_right = height[i+1];
               }
               max_right[i] = temp_max_right;
           }
       }

       // total water will be the minimum of both values
       for(int i = 0; i < height.length; i++)
       {
           int volume = Math.min(max_left[i], max_right[i]) - height[i];
           if(volume < 0)
           {
               volume = 0;
           }

           total_water+=volume;
       }

       return total_water;

   }

   public int trapOptimal(int [] height)
   {
       if(height.length == 0)
       {
           return 0;
       }
       int l = 0;
       int r =  height.length -1;
       int leftMax = height[l];
       int rightMax = height[r];
       int volume  = 0;

       while(l < r)
       {
           // shift left pointer here
           if(leftMax < rightMax)
           {
               l++;
               leftMax = Math.max(leftMax, height[l]);
               volume+=leftMax - height[l];
           }

           //shift right pointer
           else
           {
               r--;
               rightMax = Math.max(rightMax, height[r]);
               volume+= rightMax - height[r];
           }

           return volume;
       }


       // Using two pointer
   }
}
public class Main {

    public static void main(String[] args) {

        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        Solution sol = new Solution();
        int ans = sol.trap(height);
	// write your code here
    }
}
