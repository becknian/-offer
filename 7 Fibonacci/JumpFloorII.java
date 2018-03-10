/*
题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
f(n)=2^(n-1)
*/
public class Solution {
    public int JumpFloorII(int target) {
        int i = 1;
        int result = 1;
        while (i < target){
            result *= 2;
            i++;
        }
        return result;
    }
}
