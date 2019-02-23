package code.kata.stack;

public class Stack {
    private LinkedList elements = new LinkedList();

    public Stack() {
    }

    public void push(int element) {
        this.elements.addHead(element);
    }

    public int pop() {
        return elements.removeHead();
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public int getData() {
            return data;
        }
    }

    private static class LinkedList {
        private Node head;

        public int removeHead() {
            if(head == null) {
                throw new RuntimeException();
            } else {
                Node temp = head;
                head = head.getNext();
                return temp.getData();
            }
        }

        public void addHead(int element) {
            if(head == null) {
                head = new Node(element);
            } else {
                Node temp = head;
                head = new Node(element);
                head.setNext(temp);
            }
        }
    }
}
