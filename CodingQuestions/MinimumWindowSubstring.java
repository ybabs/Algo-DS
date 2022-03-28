package com.company;

// Two strings s and t, return the minimum window s
// that contains all that covers all the characters in t
// Optimal SOlution is in O(n)
// Use a two pointer solution i and j with i starting at 0
// and j starting at 0 too

import java.util.HashMap;
import java.util.Map;

class Solution{
    public String minWindow(String s, String t)
    {
        // Base cases if strings are empty, return an empty string
        if(s.isEmpty() || t.isEmpty())
        {
            return " ";
        }
        // HashMap for all characters in string t
        Map<Character, Integer> map = new HashMap<>();
        //Loop through and add hashmap for t
        for(int i = 0; i < t.length(); i++)
        {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        // Two pointers to track the substring in the main string
        int i = 0;
        int j = 0;
        // Get the current state of the hashmap
        int count = map.size();

        int left = 0;
        int right = s.length() - 1;
        int min = s.length();  // minimum window length
        boolean found = false;

        while(j < s.length())
        {
            // Increment J pointer every time J is extracted from the string
            char endChar = s.charAt(j++);
            // If the character is contained within the map,
            // decrease the occurrence of the character in the map
            if(map.containsKey(endChar))
            {
                map.put(endChar, map.get(endChar-1));
                // if value of the map is zero, we've satisfied the
                // requirements for the substring so we decrement that
                // value by 1
                if(map.get(endChar) == 0)
                {
                    count-=1;
                }
            }
            // If this is satisfied, we;ve not found the mininum substring yet
            if(count > 0)
            {
                continue;
            }
            while(count == 0)
            {
                // Every time we extract a character, move the pointer forward
                char startChar = s.charAt(i++);
                if(map.containsKey(startChar))
                {
                    map.put(startChar, map.get(startChar+1));
                    // if value of the map is zero, we've satisfied the
                    // requirements for the substring so we decrement that
                    // value by 1
                    if(map.get(startChar) > 0)
                    {
                        count+=1;
                    }
                }
            }

            if((j - i) < min)
            {
                left = i;
                right = j;
                min = j - i;

                found = true;
            }
        }

        return !found ? "":s.substring(left-1, right);

    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
