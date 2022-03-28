package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// Given an array of strings, group anagrams together
class Solution{
    public List<List<String>>GroupAnagrams(String[] strs)
    {
        List<List<String>> groupedAnagrams = new ArrayList<>();

        // Create a map
        HashMap<String, List<String>> map = new HashMap<>();

        // SOrt the characters
        for(String current: strs)
        {
            char [] characters = current.toCharArray();
            // Sort the characters to get different permutations
            Arrays.sort(characters);
            String sortedString = new String(characters);
            // check if the map contains the sorted version of the word
            if(!map.containsKey(sortedString))
            {
                // Add a new array list for the mapping
                map.put(sortedString, new ArrayList<>());
            }
                // Add current word to the grouping
                map.get(sortedString).add(current);
        }

        // Add the list to groupedAnagrams
        groupedAnagrams.addAll(map.values());

        return groupedAnagrams;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
