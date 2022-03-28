package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HighFive
{
    public  int[][] highfive(int[][] items)
    {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        // Store data first
        for(int [] item : items)
        {
            int id = item[0];
            int score = item[1];
            PriorityQueue<Integer> queue = map.get(id);

            // check queue
            if(queue == null)
            {
                queue = new PriorityQueue<>(5);
                map.put(id, queue);
            }

            // add score to the queue
            queue.add(score);
            if(queue.size()> 5)
            {
                queue.poll();
            }
        }

        // traverse hashmap and calculate average score
        int index = 0;
        int[][] res = new int[map.size()][2];
        for (int id: map.keySet())
        {
            PriorityQueue<Integer> queue = map.get(id);
            int sum = 0;

            // Add cumulative sum in the queue
            while(queue.isEmpty() != true)
            {
                sum+=queue.poll();
            }

            res[index][0] = id;
            res[index][1] = sum/5;

            // increment index
            index++;
        }
           return res;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
