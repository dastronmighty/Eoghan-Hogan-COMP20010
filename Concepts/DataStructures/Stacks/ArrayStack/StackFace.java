/**
 * StackFace
 * 
 * An interface for the Link-Based Stack datatype
 */
public interface StackFace<E> {

    // push(e) insert element e at top of stack
    public void push(E item);

    // pop()
    // Removes and returns the top element from the stack (or null if the stack is
    // empty).
    public E pop();

    // top()
    // Returns the top element of the stack, without removing it
    // (or null if the stack is empty).
    public E top();

    // size() Returns the number of elements in the stack.
    public int size();

    // empty() Returns a boolean indicating whether the stack is empty.
    public boolean empty();

}