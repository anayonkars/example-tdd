package code.kata.stack;

public class Stack<T> {
    private LinkedList<T> elements = new LinkedList();

    public Stack() {
    }

    public void push(T element) {
        this.elements.addHead(element);
    }

    public T pop() {
        return elements.removeHead();
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public T getData() {
            return data;
        }
    }

    private static class LinkedList<T> {
        private Node<T> head;

        public T removeHead() {
            if(head == null) {
                throw new RuntimeException();
            } else {
                Node<T> temp = head;
                head = head.getNext();
                return temp.getData();
            }
        }

        public void addHead(T element) {
            if(head == null) {
                head = new Node(element);
            } else {
                Node<T> temp = head;
                head = new Node(element);
                head.setNext(temp);
            }
        }
    }
}
