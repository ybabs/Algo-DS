package com.company;

import java.util.ArrayList;
import java.util.List;

// This is a recursion problem
// You'll be using backtracking
// For each index, decide if you want to pick it
// and then decide how many times you want to pick
// that index. This will resort to you making
// one of two recursive calls during each call
// Exponential time complexity
// This solution is o(2^n) as there are two possible
// solutions with each call
class Solution{
    public List<List<Integer>> CombinationSum(int [] candidates, int target)
    {
        // Declare empty List of List of Integers that stores the answers
        List<List<Integer>> ans = new ArrayList<>();
        // Call the recursive function/
        // Initial parameters are the
        // zeroth index, array of candidate numbers, target sum
        // final ArrayList with the combinations and an initial arrayList
        findCombinations(0, candidates, target, ans, new ArrayList<>());

        return ans;
    }

    private void findCombinations(int index, int[] array, int target, List<List<Integer>> ans, List<Integer> ds)
    {
        // Base Case if we have picked all elements in the candidate array
        if(index == array.length)
        {
            // Check if sum left is 0, we've potentially finished
            // out backtracking
            if(target == 0)
            {
                // Add this combination to our list
                ans.add(new ArrayList<>(ds));
            }

            return;
        }

        // The Picking the index condition
        // Check if current element is less than current target sum
        if(array[index] <= target)
        {
            // add current value at index to the data structure
            ds.add(array[index]);
            // Call the recursive function with the current index,
            // and the target value - current index value
            int newTarget = target - array[index];
            findCombinations(index, array, newTarget, ans, ds );
            // Remove that array after backtracking to prevent duplicates
            ds.remove(ds.size() -1);
        }

        // Call the not picking solution
        else
        {
            // Go to the next index with the same parameters
            findCombinations(index+1, array, target, ans, ds);
        }
    }

}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
