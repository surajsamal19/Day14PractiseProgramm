class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if (head == null) {
            throw new IllegalStateException("Stack is empty");
        }
        int poppedValue = head.data;
        head = head.next;
        return poppedValue;
    }

    public int peek() {
        if (head == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList stack = new LinkedList();

        stack.add(70);
        stack.add(30);
        stack.add(56);

        System.out.println("Stack Contents:");
        stack.display();

        System.out.println("Peeking: " + stack.peek());

        System.out.println("Popping all elements:");
        while (!stack.isEmpty()) {
            int poppedValue = stack.pop();
            System.out.println("Popped Value: " + poppedValue);
        }

        System.out.println("Stack Contents after popping:");
        stack.display();
    }
}

