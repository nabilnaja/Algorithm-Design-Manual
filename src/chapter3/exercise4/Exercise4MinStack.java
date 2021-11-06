package chapter3.exercise4;


import java.util.Optional;
import java.util.Stack;

public class Exercise4MinStack {

    Stack<Integer> stack;
    Integer min;

    public Exercise4MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public Integer peek()
    {
        if (stack.isEmpty())
            return null;
        int t = stack.peek();
        if (t < min)
            return min;
        else
            return t;
    }

    public void push(int item) {
        if (stack.isEmpty())
        {
            min = item;
            stack.push(item);
            return;
        }
        if (item < min)
        {
            stack.push(2*item - min);
            min = item;
        }
        else
            stack.push(item);
    }

    public Integer pop() {
        if (stack.isEmpty())
            return null;

        Integer t = stack.pop();

        // Minimum will change as the minimum element
        // of the stack is being removed.
        if (t < min)
        {
            final int minCopy = min;
            min = 2*min - t;
            return minCopy;
        }
        else
            return t;
    }
    public int getMin(){
        return min;
    }
}
