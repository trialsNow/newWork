package com.entrust.trials.datastructures;

/**
 * Two stacks. If StackUsingSingleLinkedList 1 empty push the element.
 * If not empty push all elements from stack 1 to stack 2 and then push elemennt.
 * Loop through stack 2 and pop all the values back to stack1
 */
import java.util.*;
public class QueueUsingStacks {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        // Push element x to the back of queue.
        public void push(int x) {
            if(s1.isEmpty()){
                s1.push(x);
            }else{
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }

                s1.push(x);

                while(!s2.isEmpty()){
                    s1.push(s2.pop());
                }
            }
        }

        // Removes the element from in front of queue.
        public void pop() {
            s1.pop();
        }

        // Get the front element.
        public int peek() {
            return s1.peek();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return s1.isEmpty();
        }
    }
