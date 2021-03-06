/*
题目描述：输入一个链表，从尾到头打印链表每个节点的值。
面试小提示：在面试中如果我们打算修改输入的数据，最好先问面试官是不是允许做修改
*/
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
// version 1: use stack (last-in first-out)
// 优点：鲁棒性好
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        ListNode node = listNode;
        while (node != null){
            stack.push(node.val);
            node = node.next;
        }
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        // stack.pop(): Removes the object at the top of this stack and returns that object as the value of this function.
        // stack.peek(): Looks at the object at the top of this stack without removing it from the stack.
        return result;
    }
}
// version 2: use recursion, do not need extra space and do not change the input ListNode
// 缺点：当链表非常长的时候，会导致函数调用的层级很深，从而有可能导致栈溢出。
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        helper(listNode, result);
        return result;
    }
    private void helper(ListNode node, ArrayList<Integer> result){
        if (node == null){
            return;
        }
        helper(node.next, result);
        result.add(node.val);
    }
}


// version 3: inplace but will change the input ListNode
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode prev = null;
        while (listNode != null){
            ListNode temp = listNode.next;
            listNode.next = prev;
            prev = listNode;
            listNode = temp;
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (prev != null){
            result.add(prev.val);
            prev = prev.next;
        }
        return result;
    }
}
