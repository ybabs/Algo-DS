package com;

import java.util.ArrayList;
import java.util.List;

// Potential BFS Question
class Solution
{
    public List<String> letterCombinations(String digits)
    {
        // Variable to return List
        List<String> res = new ArrayList<String>();

        // error checking
        if(digits == null || digits.length() == 0)
        {
            return res;
        }

        // Create an array of string with the mappings
        String [] mapping = {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        // Call a recursive that will generate the mappings
        // res Pass the result that recursively sorts mappings
        // digits: digits to create mapping for
        // "": EMpty string that represents current combination we're dealing with
        // 0: current index
        // mapping
        GetCombination(res, digits, "", 0, mapping);
        return res;

    }

    public void GetCombination(List<String> res, String digits, String current, int index, String[] mapping)
    {
        // Base case
        // Stop when wev'e gone through the digits
        if(index == digits.length())
        {
            res.add(current);
            return;
        }
        // COnvert the current letter to get mapping of the digit
        String letters = mapping[digits.charAt(index)- '0'];

        for(int i = 0; i < letters.length(); i++)
        {
            GetCombination(res, digits, current+letters.charAt(i), index+1, mapping);
        }

    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
