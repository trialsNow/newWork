package com.entrust.trials.datastructures;

/**
 * Created by rathna on 2016-05-30.
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

