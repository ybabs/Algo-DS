package com.company;

class MinPathSum
{
    public int minPathSum(int [][] grid)
    {
        // base case. if this is valid, we;ve reached
        // destination
        if(grid == null || grid.length == 0)
        {
            return 0;
        }

        // create DP array of m * n
        int rows = grid.length;
        int cols = grid[0].length;
        int [][] dp = new int[rows][cols];

        // fill the array by looping through
        for(int i = 0; i <rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                // Assign the current  value
                // of the items from the array
                dp[i][j] += grid[i][j];

                // check if we are in the middle of the grid
                // In this case we can go either right or down
                // Use the minimum value of both options in the array
                if(i > 0 && j > 0)
                {
                    // Current cell value has to be added to
                    //either the cell above or the cell to the left
                    dp[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
                 // If i > 0, we'be now moved to the right and fixed
                 // on the j axis
                else if( i > 0)
                {
                    dp[i][j] += dp[i-1][j];
                }

                else if (j > 0)
                {
                    dp[i][j] += dp[i][j - 1];
                }


            }
        }

        // return the bottom right value in the DP array
        return dp[rows -1][cols-1];
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
