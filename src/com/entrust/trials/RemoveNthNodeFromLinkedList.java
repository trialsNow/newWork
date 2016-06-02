package com.entrust.trials;



/**
 * Use fast and slow pointers. The fast pointer is n steps ahead of the slow pointer.
 * When the fast reaches the end, the slow pointer points at the previous element of the target element.
 */
public class RemoveNthNodeFromLinkedList {
    static class ListNode{
        ListNode next;
        String val;

        ListNode(String val){
            this.val=val;
        }
        ListNode(){

        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;

        for(int i=0; i<n; i++){
            fast = fast.next;
        }

        //if remove the first node
        if(fast == null){
            head = head.next;
            return head;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }

}
