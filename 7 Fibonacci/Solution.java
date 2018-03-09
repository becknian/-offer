/*
题目描述
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
注意：
确认要求的是第n项还第n个数。
第0项是0，而第一个数是0。
*/

public class Solution {
    public int Fibonacci(int n) {
        int first = 0, second = 1;
        for (int i = 1; i <= n; i++){
            int temp = first + second;
            first = second;
            second = temp;
        }
        return first;
    }
}
