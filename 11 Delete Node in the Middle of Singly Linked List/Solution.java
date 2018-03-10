/*
Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.

Example
Linked list is 1->2->3->4, and given node 3, delete the node in place 1->2->4
*/
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param node: the node in the list should be deletedt
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        if (node == null || node.next == null){
            return;
        }
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
    public void deleteNode(ListNode head, ListNode deleteNode) {
        // write your code here
        if (head == null || deleteNode == null){
            return;
        }
        if (head.next == null && head == deleteNode){ // if the list only have one node and we want to delete it, change it to null
            head = null;
            
        } else if (deletNode.next == null) { // if we want to remove the last node, we have to find its prev node, which taks O(n) time
            ListNode node = head;
            while (node.next != deleteNode){
                node = node.next;
            }
            node.next = null;
        } else { // otherwise, we can delete the node in O(1) time. This is based on an assumption that the node we want to delete is in the list.
            ListNode next = node.next;
            node.val = next.val;
            node.next = next.next;
        }
    }
}
