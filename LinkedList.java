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
    Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int dequeue() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        }
        int dequeuedValue = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return dequeuedValue;
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
        LinkedList queue = new LinkedList();

        queue.append(56);
        queue.append(30);
        queue.append(70);

        System.out.println("Queue Contents:");
        queue.display();

        int dequeuedValue1 = queue.dequeue();
        System.out.println("Dequeued Value: " + dequeuedValue1);

        int dequeuedValue2 = queue.dequeue();
        System.out.println("Dequeued Value: " + dequeuedValue2);

        System.out.println("Queue Contents after dequeue:");
        queue.display();
    }
}





