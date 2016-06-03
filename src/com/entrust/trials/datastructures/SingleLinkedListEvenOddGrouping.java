package com.entrust.trials.datastructures;

/**
 * Created by rathna on 2016-05-28.
 */
import java.util.*;

public class SingleLinkedListEvenOddGrouping{
    static TreeNode head;

    static class TreeNode{
        int data;
        TreeNode next;

        TreeNode(int data){
           this.data=data;
        }
    }
    public static TreeNode oddEvenList(TreeNode head) {
        if(head == null)
            return head;

        TreeNode result = head;
        TreeNode p1 = head;
        TreeNode p2 = head.next;
        TreeNode connectNode = head.next;

        while(p1 != null && p2 != null){
            TreeNode t = p2.next;
            if(t == null)
                break;

            p1.next = p2.next;
            p1 = p1.next;

            p2.next = p1.next;
            p2 = p2.next;
        }

        p1.next = connectNode;

        return result;
    }


    public static void main(String[] args){
        head= new TreeNode(11);
        head.next= new TreeNode(12);
        head.next.next = new TreeNode(13);
        head.next.next.next = new TreeNode(14);
        head.next.next.next = new TreeNode(15);
        oddEvenList(head);
        
    }

}
