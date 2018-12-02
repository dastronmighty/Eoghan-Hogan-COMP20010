/**
 * Deque
 */
public class Deque<T> implements DequeFace<T> {

    Stack<T> front;
    Stack<T> back;

    public Deque() {
        front = new Stack<T>();
        back = new Stack<T>();
    }

    public Stack<T> reverseStack(Stack<T> reverse) {
        Stack<T> temp = new Stack<T>();

        while (!reverse.empty()) {
            temp.push(reverse.pop());
        }
        return temp;
    }

    public Stack<T> cloneReverse(Stack<T> clone) {
        Stack<T> temp = clone.clone();
        temp = reverseStack(temp);
        return temp;
    }

    public int size() {
        return front.size();
    }

    public boolean empty() {
        return size() == 0;
    }

    public void insertFront(T e) {
        if (empty()) {
            front.push(e);
            back.push(e);
        } else {
            front.push(e);
            back = cloneReverse(front);
        }
    }

    public void insertBack(T e) {
        if (empty()) {
            front.push(e);
            back.push(e);
        } else {
            back.push(e);
            front = cloneReverse(back);
        }
    }

    public void eraseFront() {
        front.pop();
        back = cloneReverse(front);
    }

    public void eraseBack() {
        back.pop();
        front = cloneReverse(back);
    }

    public T front() {
        return front.top();
    }

    public T back() {
        return back.top();
    }

    @Override
    public String toString() {
        String dequeString = "(front) ";
        dequeString += front.toString();
        dequeString += " (Back)";
        return dequeString;
    }

}