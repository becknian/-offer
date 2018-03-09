/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.

Notice
The array may contain duplicates.

Example
Given [4,4,5,6,7,0,1,2] return 0.
*/
// a simple algorithm that can handle all input nums
// 1. Use the last number as contrast number, instead of the first one
// 2. nums[mid] == nums[end] -> end--
public class Solution {
    /*
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        //write your code here
        if (nums == null || nums.length == 0){
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            } else if (nums[mid] == nums[end]){
                end--;
            } else if (nums[mid] < nums[end]){
                end = mid;
            } else {
                start = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
