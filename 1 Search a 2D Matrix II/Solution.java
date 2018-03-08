/*
Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example
Consider the following matrix:
[
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
]
Given target = 3, return true.

Challenge
O(m+n) time and O(1) extra space
*/
public class Solution {
    /*
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        // from righ-up to left-bottom (from left-bottom to right-up is also a choice)
        int x = 0;
        int y = matrix[0].length - 1;
        int num = 0;
        while (x < matrix.length && y >= 0){
            if (matrix[x][y] == target){
                num++;
                x++;
                y--;
            } else if (matrix[x][y] > target){
                y--;
            } else { //(matrix[x][y] < target)
                x++;
            }
        }
        return num;
    }
}
