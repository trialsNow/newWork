package com.entrust.trials.datastructures;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.

 Maintain the min element while insert
 */
public class MinStackImplementation {
    class Elem{
        public int value;
        public int min;
        public Elem next;

        public Elem(int value, int min){
            this.value = value;
            this.min = min;
        }
    }
        public Elem top;

        public void push(int x) {
            if(top == null){
                top = new Elem(x, x);
            }else{
                Elem e = new Elem(x, Math.min(x,top.min));
                e.next = top;
                top = e;
            }

        }

        public Elem pop() {
            if(top == null)
                return null;
            Elem temp = top.next;
            top.next = null;
            top = temp;
            return top;
        }

        public int top() {
            if(top == null)
                return -1;
            return top.value;
        }

        public int getMin() {
            if(top == null)
                return -1;
            return top.min;
        }
    }

