package com.company;

//
// Count the number of prime numbers less than a non-negative number n
// Greedy solution would be check all numbers below number n and check if
// a number divides n evenly

// Optimal Solution would be using Sieve of Erasthothenes
// This eliminates the multiples of a number and goes on
// to the next number to eliminate the multiples of those numbers
// At the end of the solution, simple count what numbers are left
// in the solution. // Time complexity is O(N loglogN))
class Solution
{
    public int countPrimes(int n)
    {
        // Base case
        if(n <= 2)
        {
            return 0;
        }

        // Initially,create an array of n "TRUES" where trues
        // means it is a prime number
        boolean [] sieve = new boolean[n];
        // variable to keep track of primes
        int primeCount = 0;

        // fill array with "Trues
        for(int i = 0; i < n; i++)
        {
            sieve[i] = true;
        }

        // Start at number 2 and stop when i * i < n
        for(int i = 2; i * i < n; i++ )
        {
            // skip items that have been changed to false
            if(sieve[i] == true)
            {
                // This loop finds the multiples of the
                // variable i from the outer for loop
               for(int j = i; j * i < n; j++)
               {
                    sieve[j*i] = false;
               }
            }
        }

        // Count number of element in array that is true
        for(int i = 2; i < n; i++)
        {
            if(sieve[i] == true)
            {
                primeCount++;
            }
        }

        return primeCount;
    }

    public int countPrimesGreedy(int n)
    {
        int count = 0;
        boolean isPrime = false;
        int curr_val = n;

     while(curr_val != 1 )
        {
            for(int i = 2; i < curr_val; i++)
            {
                if(curr_val % i  == 0)
                {
                    count++;
                    break;
                }
            }
            curr_val--;
        }
        return count;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution sol = new Solution();
        int x = 100;

        int val = sol.countPrimesGreedy(x);
        int prime = x - val - 1;

        int valEra = sol.countPrimes(x);


    }
}
