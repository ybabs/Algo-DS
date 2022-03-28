package com.company;

import java.util.HashMap;

class Solution
{
    char FirstNonRepeatingCharacter(String s)
    {
        HashMap<Character, Integer> charCounts = new HashMap<>();
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(charCounts.containsKey(c))
            {
                charCounts.put(c, charCounts.get(c)+1);
            }
            else {
                charCounts.put(c, 1);
            }
        }

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(charCounts.get(c) == 1)
            {
                return c;
            }
        }

        return '_';
    }

    int  FirstNonRepeatingCharacterArray(String s)
    {
        int [] charHashmap = new int[26];

        for(char c : s.toCharArray())
        {
            charHashmap[c -'a']++;
        }

        for(char c: s.toCharArray())
        {
            if(charHashmap[c-'a'] == 1)
            {
                return c;
            }
        }
        return -1;

    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
