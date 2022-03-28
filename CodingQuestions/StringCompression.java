package com.company;
class Solution{
    public int compress (char [] chars)
    {
        int index = 0;
        int i = 0;
        while(i < chars.length)
        {
            int j = i;
            while(j < chars.length && and chars[j] == chars[i])
            {
                j++;
            }
            chars[index++] = chars[i];
            if(j - i > 1)
            {
                String count = j - i + "";
                for(char c: count.toCharArray())
                {
                    chars[index++] = c;
                }
            }

            i = j;
        }

        return index;
    }

    public int compresstwo(char [] chars)
    {
        String out = ""
        int sum = 1;
        int i = 0;
        for (int i = 0; i < chars.length-1; i++)
        {
            if(chars[i] == chars[i + 1])
            {
                sum++;
            }
            else
            {
                out = out + chars[i] + sum;
                sum = 1;
            }
        }

        out = out + chars[chars.length -1] + sum;

        return out.length();
    }

}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
