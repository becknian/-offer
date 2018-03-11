/*
Find the nth to last element of a singly linked list. 
The minimum number of nodes in list is n.

Example
Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.
*/
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
// 要注意代码的鲁棒性，也就是考虑边界情况
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0){ // when list is null or k <= 0
            return null;
        }
        ListNode ahead = head;
        ListNode behind = head;
        int i = 1;
        while (i < k){
            if (ahead.next != null){
                ahead = ahead.next;
                i++;
            } else { // occure when k > size of list
                return null;
            }            
        }
        while (ahead.next != null){
            behind = behind.next;
            ahead = ahead.next;
        }
        return behind;
    }
}
