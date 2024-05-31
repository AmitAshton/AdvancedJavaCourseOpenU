package Question1;

public class LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public Node<E> getHead(){
        return head;
    }

    public Node<E> getTail(){
        return tail;
    }

    private boolean isEmpty(){
        return head == null;
    }

    public void add(E content) {
        Node<E> nodeToAdd = new Node<>(content);
        if (isEmpty()) {
            head = nodeToAdd;
            tail = nodeToAdd;
        } else {
            tail.setNext(nodeToAdd);
            tail = tail.getNext();
        }
    }

    public E remove() throws EmptyListException {
        if (head == null) {
            throw new EmptyListException("List is Empty!");
        }
        Node<E> nodeToRemove = head;
        head = head.getNext();
        nodeToRemove.setNext(null);

        return nodeToRemove.getContent();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getContent());
            if (current.getNext() != null) {
                sb.append(" -> ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }

    void reverseList() {
        Node<E> prevNode = null;
        Node<E> currentNode = head;
        Node<E> nextNode;

        while (currentNode != null) {
            nextNode = currentNode.getNext();
            currentNode.setNext(prevNode);
            prevNode = currentNode;
            currentNode = nextNode;
        }

        Node<E> temp = head;
        head = tail;
        tail = temp;
    }
}
