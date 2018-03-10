/*

Count how many 1 in binary representation of a 32-bit integer.

Example
Given 32, return 1
Given 5, return 2
Given 1023, return 9
*/
// Both version 1 and version 2 need O(n) time for n bits number. But version 3 only need O(k) time for k numbers of 1 in the number.
// version 1
public class Solution {
    /*
     * @param num: An integer
     * @return: An integer
     */
    public int countOnes(int num) {
        // write your code here
        int count = 0;
        while (num != 0){
            count += num & 1;
            num =  num >>> 1;
        }
        return count;
    }
}
// version 2
public class Solution {
    public int countOnes(int num) {
        // write your code here
        int count = 0;
        int flag = 1;
        while (flag != 0){
            if ((num & flag) == flag){
                count ++;
            }
            flag =  flag << 1;
        }
        return count;
    }
}
// version 3
public class Solution {
    public int countOnes(int num) {
        // write your code here
        int count = 0;
        while (num != 0){
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}
