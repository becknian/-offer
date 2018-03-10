/*
Print numbers from 1 to the largest number with N digits
这道题目可能有两个考察侧重点：
1.当n非常大时，如何设计使得打印的数字不会越界
2.如何使用recursion的方式将数字加入到一个ArrayList里，并且recursion的最大深度为N
根据不同的考察侧重点会有不同的解题思路。
*/
// version for 1
// 将每位数装进数组里，这样就不会越界
public class PrintToMaxOfNDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintToMaxOfNDigits pm = new PrintToMaxOfNDigits();
		pm.printToNDigits(2);

	}
	public void printToNDigits(int n) {
		int[] num = new int[n];
		for (int i = 0; i < n; i++){
			num[i] = 0;
		}
		while (increment(num)){
			print(num);
		}
	}
	private boolean increment(int[] num){
		int index = num.length - 1;
		while(index >= 0){
			if (num[index] < 9){
				num[index] += 1;
				break;
			} else {
				num[index] = 0;
				index--;
			}
		}
		if (index < 0){
			return false;
		}
		return true;
	}
	private void print(int[] num){
		int index = 0;
		int len = num.length;
		while (num[index] == 0){
			index++;
		}
		for (int i = index; i < len; i++){
			System.out.print(num[i]);
			if (i == len - 1){
				System.out.print('\n');
			}
		}
	}
}
// version for 2
public class Solution {
    /**
     * @param n: An integer
     * @return: An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> results = new ArrayList<>();
        recursion(n, 0, results);
        return results;
    }
    private void recursion(int n, int ans, List<Integer> results) {
        if (n == 0){
            if (ans > 0){
                results.add(ans);
            }
            return;
        }
        for (int i = 0; i <= 9; i++){
            recursion(n - 1, ans * 10 + i, results);
        }
    }
}
