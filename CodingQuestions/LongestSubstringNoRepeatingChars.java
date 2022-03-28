package com.company;

import java.util.HashSet;

// This is a sliding window problem easy
// Time complexity = O(n)
class Solution{
    public int lengthofLongestSubstring(String s)
    {
        // Use two pointers to keep track of the position
        // of the substring
        int i = 0;
        int j = 0;
        int max = 0;
        // Use a HashSet of keep track of where you are
        HashSet<Character>hash_set = new HashSet<>();

        while(j < s.length())
        {
            // if character at the string is not in the hashset,
            // add it to the hashset
            if(!hash_set.contains(s.charAt(j)))
            {
                hash_set.add(s.charAt(j));
                j++;
                max = Math.max((hash_set.size(), max);
            }
            else
            {
                // If character is in the hash, remove the
                // oldest element currently in the hash
                hash_set.remove((s.charAt(i)));
                i++;
            }
        }

        return max;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
