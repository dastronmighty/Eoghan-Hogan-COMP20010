/**
 * StackTest
 */
public class StackTest {

    public static int deleteRecursively(Stack toDelete) {
        if (toDelete.size() == 0) {
            return 0;
        }
        toDelete.pop();
        return 1 + deleteRecursively(toDelete);
    }

    public static Stack<String> reverseStack(Stack<String> reverse) {
        Stack<String> a = new Stack<String>();

        while (!reverse.empty()) {
            a.push(reverse.pop());
        }
        return a;
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        Stack<String> myStack = new Stack<String>();

        System.out.println(myStack.toString());
        myStack.push("Hello");
        System.out.println(myStack.toString());
        myStack.push("World");
        System.out.println(myStack.toString());
        myStack.push("Check 1 2");
        System.out.println(myStack.toString());
        myStack.push("Lol");
        System.out.println(myStack.toString());

        System.out.println("Element at top of stack being removed: " + myStack.pop());
        System.out.println(myStack.toString());
        System.out.println("Element at top of stack being removed: " + myStack.pop());
        System.out.println(myStack.toString());
        System.out.println("Element at top of stack: " + myStack.top());

        System.out.println("\nSize of stack: " + myStack.size());

        myStack.push("1");
        myStack.push("2");
        myStack.push("3");
        myStack.push("4");
        myStack.push("5");

        System.out.println("\nSize of stack: " + myStack.size());
        System.out.println(myStack.toString());
        myStack = reverseStack(myStack);

        System.out.println("Reversed  stack:\n" + myStack.toString());
        Stack<String> newMyStack = myStack.clone();
        System.out.println("new:\n" + newMyStack.toString());

        System.out.println("Deleted " + deleteRecursively(newMyStack) + " elements from new stack");

        System.out.println("old: ");
        System.out.println(myStack.toString());
        System.out.println("new");
        System.out.println(newMyStack.toString());

        System.out.println("\nSize of new stack: " + newMyStack.size());

    }
}