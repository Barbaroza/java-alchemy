package com.pmb.wait_2023_02_02;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author lvrui
 */
public class StackSolution {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack2.push(node);

    }

    public int pop() {
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        return stack1.pop();
    }

    public static class S2 {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public void push(int node) {
            stack.push(node);
            int t = node;
            if (!minStack.isEmpty()) {
                if (minStack.peek() < node) {
                    t = minStack.peek();
                }
            }

            minStack.push(t);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }


    private char s1 = '(';
    private char s2 = ')';

    private char s3 = '[';
    private char s4 = ']';
    private Stack<Character> stack = new Stack();

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != s2 && chars[i] != s4) {
                stack.push(chars[i]);

            } else {

                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (chars[i] == s2 && pop != s1) {
                    return false;
                }

                if (chars[i] == s4 && pop != s3) {
                    return false;
                }
            }
        }


        return stack.isEmpty();
        // write code here
    }


    public static void main(String[] args) {
        StackSolution stackSolution = new StackSolution();

        boolean valid = stackSolution.isValid("()");
    }

    private LinkedList<Integer> dequeue = new LinkedList<Integer>();

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(num == null || num.length <size || size == 0){
            return ans;
        }
        for(int i = 0;i<size;i++){

            while(!dequeue.isEmpty() && num[dequeue.peekLast()]<num[i]){
                dequeue.pollLast();
            }
            dequeue.addLast(i);
        }




        for(int i =size;i<num.length;i++){

            ans.add(num[dequeue.peekFirst()]);
            while(!dequeue.isEmpty() && dequeue.peekFirst() < (i - size + 1)){
                dequeue.pollFirst();
            }
            while(!dequeue.isEmpty() && num[dequeue.peekLast()]<num[i]){
                dequeue.pollLast();
            }
            dequeue.addLast(i);
        }

        ans.add(num[dequeue.peekFirst()]);




        return ans;
    }
}
