package com.company;

class TwoSum2 {

    public int[] solution(int [] numbers, int target)
    {
        int l = 0;
        int r = numbers.length - 1;

        while(l < r)
        {
            int sum = numbers[l] + numbers[r];
            if (sum > target)
            {
                r-=1;
            }
            else if(sum < target)
            {
                l+=1;
            }
            else
            {
                return new int[]{l+1, r+1};
            }
        }
        return new int [] {l+1, r+1};
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
