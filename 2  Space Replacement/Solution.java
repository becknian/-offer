/*
Write a method to replace all spaces in a string with %20. The string is given in a characters array, you can assume it has enough space for replacement and you are given the true length of the string.
You code should also return the new length of the string after replacement.

Example:
Given "Mr John Smith", length = 13.
The string after replacement should be "Mr%20John%20Smith", you need to change the string in-place and return the new length 17.

Challenge:
O(n) time, in-place
*/
public class Solution {
    /*
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    /*
    In theory, this problem is unable to be solved in-place in O(n) runtime using Java, because list cannot expand inlpace in Java. 
    But in this problem, the char[] list that is introduced in replaceBlank has a very big size, so that we do not need to expand the list.
    */
    public int replaceBlank(char[] string, int length) {
        // write your code here
        if (length == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++){
            if (string[i] == ' '){
                count++;
            }
        }
        int newLen = length + 2 * count;
        int j = newLen - 1;
        // from back to front
        for (int i = length - 1; i >= 0; i--){
            if (string[i] != ' '){
                string[j] = string[i];
                j--;
            } else {
                string[j--] = '0';
                string[j--] = '2';
                string[j--] = '%';
            }
            if (i == j){
                break;
            }
        }
        return newLen;
    }
}
