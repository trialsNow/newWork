package com.interview.linklist;

/**
 his problem can be solved in linear time. The steps are listed below:

 Step 1. Find the middle element of the linked list - This can be done in linear time.

 Step 2: Reverse the second part of the linked list (from middle to end) using recursion -
 This can be done in linear time. Refer to this post.

 Step 3: Use two pointers; one from the original start node and the other from the start of now reversed second part of the list.
 Move those pointers to their next nodes and compare. If they are equal till they hit the middle portion of the list, the linked list contains a palindrome string.
 */
public class LinkListIsPalindrome {

    static class ListNode{
        ListNode next;
        String val;

        ListNode(String val){
            this.val=val;
        }
        ListNode(){

        }
    }

    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next==null)
            return true;

        //find list center
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        //reverse second part of the list
        ListNode p1 = secondHead;
        ListNode p2 = p1.next;

        while(p1!=null && p2!=null){
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        secondHead.next = null;

        //compare two sublists now
        ListNode p = (p2==null?p1:p2);
        ListNode q = head.next;
        while(p!=null){
            if(p.val.compareTo(q.val)!=0)
                return false;

            p = p.next;
            q = q.next;

        }

        return true;
    }
    
    public static void main(String args[]){
        ListNode head = new ListNode();
        head.next = new ListNode("M");
        head.next.next = new ListNode("A");
        head.next.next.next = new ListNode("D");
        head.next.next.next.next = new ListNode("A");
        head.next.next.next.next.next = new ListNode("M");
        LinkListIsPalindrome llp = new LinkListIsPalindrome();
        System.out.println(llp.isPalindrome(head));
    }
}
