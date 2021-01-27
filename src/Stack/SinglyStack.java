package Stack;
// TODO add Empty, Search
/**
 * Project: DataStructureFinal
 * Package: Stack
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 25.01.2021
 * <p>
 * Singly Linked List implementation of a Stack
 */
public class SinglyStack {
    /**
     * Elements in Linked List represented as nodes. Node has to have data and pointer of next node.
     */
    static class Node {
        int data;
        Node next; // pointer of next node

        /**
         * Constructor to instantiate new instances with data
         *
         * @param data is the data of node
         */
        public Node(int data) {
            this.data = data;
        }
    }

    private int size = 0;
    private Node head; // first node of stack
    private Node tail; // last node of stack

    /**
     * New node will be pushed to stack
     *
     * @param val is the data of new node
     */
    public void push(int val) {
        Node newNode = new Node(val);

        // if stack is empty (size == 0)
        if (head == null) {
            head = newNode;
            // if stack has only one element, head and tail should point the same node
            tail = head;
            size++;
            return;
        }

        // new node will be the last element-tail of stack
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    /**
     * Last node will be removed from stack
     */
    public void pop() {
        // if list is null
        if (size == 0) {
            System.out.println("Stack is empty. You cant Pop element!");
            return;
        }

        // if list has only one element
        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }

        // iterator to iterate until arrive previous of tail
        Node temp = head;

        while (temp.next != tail) temp = temp.next;

        // tail to previous node
        tail = temp;
        // last element will be garbage because nothing will point it. It will be collected by garbage collector
        temp.next = null;

        size--;
    }

    /**
     * Gets the last node's data from stack
     *
     * @return data of last node if stack is not empty, otherwise error message
     */
    public String peek() {
        return tail == null ? "Stack is empty. There is no last element to show!" : String.valueOf(tail.data);
    }

    /**
     * Displays all data from stack
     */
    public void display() {
        Node temp = head;

        // until temp does not point any node, print nodes data of stack
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }


}

/**
 * Test class to test out singly linked list implementation of stack
 */
class Test {
    public static void main(String[] args) {
        SinglyStack stack = new SinglyStack();

        System.out.println("----------PUSH PROCESS--------");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.display();

        System.out.println();
        System.out.println("----------PEEK PROCESS--------");
        System.out.println(stack.peek());

        System.out.println("----------POP PROCESS-1--------");
        popAndDisplay(stack);
        popAndDisplay(stack);
        popAndDisplay(stack);
        popAndDisplay(stack);
        popAndDisplay(stack);
        popAndDisplay(stack);
        popAndDisplay(stack);
        popAndDisplay(stack);

        System.out.println(stack.peek());
    }

    private static void popAndDisplay(SinglyStack stack) {
        stack.display();
        System.out.println();
        stack.pop();
    }
}