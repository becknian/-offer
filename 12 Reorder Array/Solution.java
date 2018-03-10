/*
题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
*/
// version 1: inplace but unstable(cannot guarantee the invariability of relative locations in odd numbers and even numbers). Need O(n) time.
public class Solution {
    public void reOrderArray(int [] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right){
            while (left < right && !isEven(array[left])){
                left++;
            }
            while (left < right && isEven(array[right])){
                right--;
            }
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }
    private boolean isEven(int num){
        return (num & 1) == 0;
    }
}
// version 2: need extra space but stable. Need O(n) time.
public class Solution {
    public void reOrderArray(int [] array) {
        int len = array.length;
        int[] temp = new int[len];
        int index = 0;
        // add all odd numbers to temp
        for (int i = 0; i < len; i++){
            if (!isEven(array[i])){
                temp[index++] = array[i];
            }
        }
        // add all even numbers to temp
        for (int i = 0; i < len; i++){
            if (isEven(array[i])){
                temp[index++] = array[i];
            }
        }
        // transfer temp to array
        for (int i = 0; i < len; i++){
            array[i] = temp[i];
        }
    }
    private boolean isEven(int num){
        return (num & 1) == 0;
    }
}
