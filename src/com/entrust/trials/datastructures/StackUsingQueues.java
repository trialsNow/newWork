package com.entrust.trials.datastructures;

import java.util.*;

/**
 * Two Queues, if q1 & q2 empty put in queue1,
 * if not empty , check which q has elememnts.If q1 has elements put the new
 * element in q2. then loop through q1 and poll one by one to q2. Now q1 becomes empty.
 * q2 has values
 * check which queue has values and then pop from there
 */
public class StackUsingQueues {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        // Push element x onto stack.
        public void push(int x) {
            if(empty()){
                queue1.offer(x);
            }else{
                if(queue1.size()>0){
                    queue2.offer(x);
                    int size = queue1.size();
                    while(size>0){
                        queue2.offer(queue1.poll());
                        size--;
                    }
                }else if(queue2.size()>0){
                    queue1.offer(x);
                    int size = queue2.size();
                    while(size>0){
                        queue1.offer(queue2.poll());
                        size--;
                    }
                }
            }
        }

        // Removes the element on top of the stack.
        public int pop() {
            if(queue1.size()>0){
               return queue1.poll();
            }else if(queue2.size()>0){
               return queue2.poll();
            }
            return 0;
        }

        // Get the top element.
        public int top() {
            if(queue1.size()>0){
                return queue1.peek();
            }else if(queue2.size()>0){
                return queue2.peek();
            }
            return 0;
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return queue1.isEmpty() & queue2.isEmpty();
        }

    public static void main(String[] args){
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(10);
        stack.push(9);
        stack.push(8);

        System.out.println(stack.pop());
    }
}
