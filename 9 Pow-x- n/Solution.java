/*
Implement pow(x, n).

Notice
You don't need to care about the precision of your answer, 
it's acceptable if the expected answer and your answer 's difference is smaller than 1e-3.

Example
Pow(2.1, 3) = 9.261
Pow(0, 1) = 0
Pow(1, 0) = 1

Challenge 
O(logn) time
*/
public class Solution {
    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    // the input is invalid when base=0 and exponent<=0. We can check its value to find if the input is valid or not
    public boolean invalidInput = false; 
    public double myPow(double base, int exponent) {
        // write your code here
        if (equal(base, 0.0) && exponent <= 0){
            invalidInput = true;
            return 0;
        }
        int absExponent = exponent;
        if (exponent < 0){
            absExponent = Math.abs(exponent);
        }
        double result = recursionPower(base, absExponent);
        if (exponent < 0){
            return 1 / result;
        } else {
            return result;
        }   
    }
    /*
    a^n = a^(n/2) * a^(n/2)         if n is odd
        = a^((n-1)/2) * a^((n-1)/2) if n is even
    */
    private double recursionPower(double base, int exponent){
        if (exponent == 0){
            return 1;
        }
        if (exponent == 1){
            return base;
        }
        double result = recursionPower(base, exponent >>> 1); 
        // use >>> because when exponent = -2147483648, Math.abs() will fail since it is the max integer
        
        result *= result;
        if ((exponent & 1) == 1){
            return result *= base;
        } 
        return result;
    }
    private double powerWithExp(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < exponent; i++){
            result *= base;
        }
        return result;
    }
    private boolean equal(double num1, double num2) { // cannot use == to check if two double values are equal or not.
        if (Math.abs(num1 - num2) <= 0.0000000000001){
            return true;
        } else {
            return false;
        }
    }
    // public double myPow(double x, int n) {
    //     // Write your code here
    //     if (n == 0) {
    //         return 1;
    //     }

    //     if (n == 1) {
    //         return x;
    //     }

    //     boolean isNegative = false;
    //     if (n < 0) {
    //         isNegative = true;
    //     }

    //     int k = n / 2;
    //     int l = n - k * 2;
    //     double t1 = myPow(x, Math.abs(k));
    //     double t2 = myPow(x, Math.abs(l));
    //     if (isNegative) {
    //         return 1 / (t1 * t1 * t2);
    //     } else {
    //         return t1 * t1 * t2;
    //     }
    // }
}
