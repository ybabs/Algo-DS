package com.company;
// You're given an array of integers and an integer target. Return the
// index of two numbers in the array that add up to the
// target
// Best method is to use a Hashmap that stores the position and value of the array elements


import java.util.HashMap;
import java.util.Map;

class TwoSum
{
    private int returnArray [];
    public int[] bruteforce(int [] nums, int target)
    {
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i+1; j < nums.length; j++)
            {
                  int complement = target - nums[i];

                  if(complement == nums[j])
                  {
                      return new int[]{i,j};
                  }
            }
        }
        throw new IllegalArgumentException("Two numbers nnot found");
    }

    public int[] HashMapSolution(int [] nums, int target)
    {
        Map<Integer, Integer> TwoSumMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            int complement = target - nums[i];

            if(TwoSumMap.containsKey(complement))
            {
                return new int[]{TwoSumMap.get(complement), i};
            }
            TwoSumMap.put(nums[i], i);

        }

        throw new IllegalArgumentException("Two numbers nnot found");
    }

}
public class Main {

    public static void main(String[] args) {

        TwoSum twosum = new TwoSum();

        int nums[] = {2, 7, 11, 15};
        int target = 9;

        int sol[] = {0,0};
        sol = twosum.HashMapSolution( nums,  target);
        System.out.format("%d, %d", sol[0], sol[1]);

        // write your code here
    }
}
