package org.example.model;

public class Ladder {
    int head;
    int tail;

    public Ladder(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }
}
