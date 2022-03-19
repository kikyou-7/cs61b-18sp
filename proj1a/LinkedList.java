public class LinkedList<T> {
    private class Node {
        T value;
        Node pre, next;
        Node(T item, Node pre, Node next) {
            this.value = item;
            this.pre = pre;
            this.next = next;
        }
    }

    public Node head, tail;
    public int size;

    public LinkedList() {
        head = new Node(null, null, null);
        tail = new Node(null, null, null);
        size = 0;
    }
    public void addFirst(T item) {
        head.next = new Node(item, head, head.next);
        if (head.next.next != null) {
            head.next.next.pre = head.next;
        }
        size += 1;
    }
    public void addLast(T item) {
        tail.pre = new Node(item, tail.pre, tail);
        if (tail.pre.pre != null) {

        }
        size += 1;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size() {
        return this.size;
    }
    public void printDeque() {
        Node p = head;
        while(p != null) {
            System.out.print(p.value + " ");
            p = p.next;
        }
        System.out.println("");
    }
    public T removeFirst() {
        if (head == null) {
            return null;
        }
        size -= 1;
        Node p = head;
        head = head.next;
        if (size == 0){
            tail = null;
        }
        else {
            head.pre = null;
        }
        return p.value;
    }
    public T removeLast() {
        if (tail == null){
            return null;
        }
        size -= 1;
        Node p = tail;
        tail = tail.pre;
        if (size == 0) {
            head = null; // tail = null
        }
        else {
            tail.next = null;
        }
        return p.value;
    }
    public T get(int index) {
        Node p = head;
        while (index != 0 && p != null) {
            index--;
            p = p.next;
        }
        if (p == null) {
            return null;
        }
        else {
            return p.value;
        }
    }
    private T dfs(Node p, int index){
        if (p == null) {
            return null;
        }
        else if(index == 0) {
            return p.value;
        }
        return dfs(p.next, index - 1);
    }
    public T getRecursive(int index) {
        return dfs(head, index);
    }
}
