import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    // Constructor
    public MinStack() {

        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element
    public void push(int val) {

        stack.push(val);

        // push into minStack if empty or val <= current min
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    // Pop element
    public void pop() {

        int removed = stack.pop();

        if(removed == minStack.peek()){
            minStack.pop();
        }
    }

    // Get Top element
    public int top() {

        return stack.peek();
    }

    // Get Minimum element
    public int getMin() {

        return minStack.peek();
    }
}