class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front;
    Node rear;

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        int dequeuedData = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // Reset rear when the queue becomes empty
        }
        return dequeuedData;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(56);
        queue.enqueue(30);
        queue.enqueue(70);

        System.out.println("Queue Contents:");
        while (!queue.isEmpty()) {
            System.out.println("Dequeue: " + queue.dequeue());
        }
    }
}





