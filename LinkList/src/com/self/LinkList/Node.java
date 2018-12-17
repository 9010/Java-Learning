package com.self.LinkList;

public class Node {

    private Node previous;
    private Node next;
    Object element;

    public Node(Node previous, Node next, Object obj) {
        this.previous = previous;
        this.next = next;
        this.element = obj;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setObj(Object obj) {
        this.element = obj;
    }

    public Node getPrevious() {
        return previous;
    }

    public Node getNext() {
        return next;
    }

    public Object getElement() {
        return element;
    }
}
