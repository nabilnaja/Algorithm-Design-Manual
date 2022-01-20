package chapter3.leetcode232;
import java.util.Stack;

public class MyQueue {
    Stack<Integer> mainStorage;
    Stack<Integer> helper;

    public MyQueue() {
        mainStorage = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        while (!mainStorage.empty()){
            helper.push(mainStorage.pop());
        }
        mainStorage.push(x);
        while (!helper.empty()){
            mainStorage.push(helper.pop());
        }
    }

    public int pop() {
        return mainStorage.pop();
    }

    public int peek() {
        return mainStorage.peek();
    }

    public boolean empty() {
        return mainStorage.empty();
    }
}