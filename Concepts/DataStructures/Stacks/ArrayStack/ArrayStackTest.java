/**
 * ArrayStackTest
 */
public class ArrayStackTest {

    public static void main(String[] args) {

        ArrayStack myArrStack = new ArrayStack<Integer>(5);

        System.out.println(myArrStack.toString());
        myArrStack.push(1);
        System.out.println(myArrStack.toString());
        myArrStack.push(2);
        System.out.println(myArrStack.toString());
        myArrStack.push(3);
        System.out.println(myArrStack.toString());
        myArrStack.push(4);
        System.out.println(myArrStack.toString());
        myArrStack.push(5);
        System.out.println("stack size: " + myArrStack.size());
        System.out.println(myArrStack.toString());
        myArrStack.push(5);
        System.out.println(myArrStack.toString());

        System.out.println("Element at top of stack being removed: " + myArrStack.pop());
        System.out.println(myArrStack.toString());
        System.out.println("Element at top of stack being removed: " + myArrStack.pop());
        System.out.println(myArrStack.toString());
        myArrStack.push(5);
        System.out.println(myArrStack.toString());
        System.out.println("Element at top of stack: " + myArrStack.top());

    }
}