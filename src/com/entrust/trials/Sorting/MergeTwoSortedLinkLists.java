package com.entrust.trials.Sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by rathna on 2016-05-28.
 */
public class MergeTwoSortedLinkLists {

    private static class ListNode {
        int val;
        ListNode next;
        private ListNode(int x){
            this.val=x;
        }

        private ListNode(){

        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });

        ListNode head = new ListNode(0);
        ListNode p = head;

        for(ListNode list: lists){
            if(list!=null)
                queue.offer(list);
        }

        while(!queue.isEmpty()){
            ListNode n = queue.poll();
            p.next = n;
            p=p.next;

            if(n.next!=null)
                queue.offer(n.next);
        }

        return head.next;

    }
}
