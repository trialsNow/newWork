package com.entrust.trials.datastructures;

/**
 * If we have 2 pointers - fast and slow.
 * It is guaranteed that the fast one will meet the slow one if there exists a circle.
 */
public class LinkedListCycle {

    private static Node head;
    private static class Node {
        int data;
        Node next;
        private Node(int x){
            this.data=x;
        }

        private Node(){

        }
    }

    public LinkedListCycle(){
        head= new Node();
    }

    private static boolean cycleValidation(){
        Node i=head;
        Node j = head;

        while(i!=null && i.next!=null){
            j= j.next;
            i=i.next.next;

            if (i==j){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
        LinkedListCycle lsb= new LinkedListCycle();
        head.next= new Node(10);
        head.next.next = new Node(9);
        head.next.next.next= new Node(10);
        head.next.next.next.next= head.next;
        System.out.println(cycleValidation());
    }
}
