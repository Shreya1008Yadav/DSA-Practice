class MinStack {

    // Main stack to store all the elements.
    Stack<Integer> stack;

    // Auxiliary stack to keep track of the minimum element.
    // The top of this stack always contains the current minimum.
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int value) {

        // If the stack is empty, the current value is also
        // the minimum element.
        if (stack.isEmpty()) {
            stack.push(value);
            min.push(value);
            return;
        }

        // Add the value to the main stack.
        stack.push(value);

        // If the new value is smaller than or equal to the
        // current minimum, add it to the minimum stack as well.
        //
        // Using >= is important because duplicate minimum values
        // need to be stored separately.
        if (min.peek() >= value)
            min.push(value);
    }

    public void pop() {

        // Nothing to remove if the stack is empty.
        if (stack.isEmpty())
            return;

        // If the element being removed is the current minimum,
        // remove it from the minimum stack as well.
        if (stack.peek().equals(min.peek()))
            min.pop();

        // Remove the top element from the main stack.
        stack.pop();
    }

    public int top() {

        // Return -1 if the stack is empty.
        if (stack.isEmpty())
            return -1;

        // Return the top element of the stack.
        return stack.peek();
    }

    public int getMin() {

        // Return -1 if there is no minimum element.
        if (min.isEmpty())
            return -1;

        // The top of the min stack is always the
        // minimum element of the main stack.
        return min.peek();
    }
}

