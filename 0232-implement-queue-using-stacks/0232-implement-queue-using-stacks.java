class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    int size = 0;
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x);
        size++;
    }
    
    public int pop() {
        while(!st1.isEmpty())
        {
            st2.push(st1.pop());
        }

        int val = st2.pop();

        //revert
        while(!st2.isEmpty())
        {
            st1.push(st2.pop());
        }

        size--;
        return val;
    }
    
    public int peek() {
        while(!st1.isEmpty())
        {
            st2.push(st1.pop());
        }

        int val = st2.peek();

        //revert
        while(!st2.isEmpty())
        {
            st1.push(st2.pop());
        }

        return val;
    }
    
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */