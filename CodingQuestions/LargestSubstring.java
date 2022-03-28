package com.company;

class Solution
{
    public int LargestSubstring(String s)
    {
        int largestStringCount = 0;
        int tempCount = 1;
        int startIndex = 0;
        char currChar;
        char prevChar = ' ';

        if (s.length() == 0)
        {
            return 0;
        }
        for(int i = 0; i < s.length(); i++)
        {
            currChar = s.charAt(i);
           if( currChar == prevChar)
           {
               tempCount++;
           }
           else
           {
               startIndex = i;
               tempCount = 1;
           }
           if(tempCount > largestStringCount && tempCount != 1)
           {
               largestStringCount = tempCount;
           }
           prevChar = currChar;
        }
        return largestStringCount;
    }

    public int[] RepeatedSubstring(String s)
    {
        // Base case
        if(s.length() == 0)
        {
            return new int[]{-1, 0};
        }

        if(s.length() == 1)
        {
            return new int []{0,1};
        }

        int j = 0;
        int i = 0;
        int largestSubStringCOunt = 0;
        int tempCount = 1;

        while(j < s.length())
        {
            if(s.charAt(i) == s.charAt(j))
            {
                tempCount++;
            }
            else
            {
              i= j;
              tempCount = 1;
            }
            if(tempCount > largestSubStringCOunt)
            {
                largestSubStringCOunt = tempCount;
            }
            j++;
        }

        return new int[]{i, largestSubStringCOunt};

    }
}

public class Main {

    public static void main(String[] args) {

        Solution sol = new Solution();
        String s =  "aaBBccccc";
        int val = sol.LargestSubstring(s);

        int [] val2 = sol.RepeatedSubstring(s);

	// write your code here
    }
}
