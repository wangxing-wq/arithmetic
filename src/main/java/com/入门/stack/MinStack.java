package com.入门.stack;

class MinStack {

    private Node header = new Node();

    public MinStack() {

    }

    public void push(int val) {
        header = new Node(val,header);
    }

    public void pop() {
        if (header.next != null){
            header = header.next;
        }
    }

    public int top() {
        return header.val;
    }

    public int getMin() {
        int result = header.val;
        Node next = header;
        while (next.next != null){
            if (next.val < result){
                result = next.val;
            }
            next = next.next;
        }
        return result;
    }

    static class Node{

        int val;
        Node next;

        public Node(){}

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
