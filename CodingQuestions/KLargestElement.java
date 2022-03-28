package com.company;

class KthLargest
{
    public int findKthLargest(int [] nums, int k)
    {
        Arrays.sort(nums);
        return nums[nums.length -k]; // Easiest SOlution
    }

    // Try to use a heap when finding smallest or largest element of something
    public  int KMinHeap(int [] nums, int k)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for(int i = 0; i < nums.length; i++)
        {
            minHeap.add(i);

            if(minHeap.size() > k)
            {
                minHeap.remove();
            }
        }

        return minHeap.remove() // root of element will have the kth element
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        KthLargest k = new KthLargest();
    }
}
