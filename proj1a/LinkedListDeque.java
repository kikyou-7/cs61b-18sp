public class LinkedListDeque<T> {
    private class node {
        T value;
        node pre,next;
        node(T item, node pre, node next){
            this.value = item;
            this.pre = pre;
            this.next = next;
        }
    }

    public node head, tail;
    public int size;

    public LinkedListDeque() {
        head = tail = null;
        size = 0;
    }
    public void addFirst(T item) {
        this.head = new node(item, null, this.head);
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }
    public void addLast(T item) {
        this.tail = new node(item, this.tail, null);
        if (head == null) {
            head = tail;
        }
        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return this.size;
    }
    public void printDeque() {
        node p = head;
        while(p != null) {
            System.out.print(p.value + " ");
            p = p.next;
        }
    }
    public T removeFirst() {
        if (head == null){
            return null;
        }
        size -= 1;
        node p = head;
        head = head.next;
        if (head != null) {
            head.pre = null;
        }
        else {
            tail = null;
        }
        return p.value;
    }
    public T removeLast() {
        if (tail == null){
            return null;
        }
        size -= 1;
        node p = tail;
        tail = tail.pre;
        if (tail != null) {
            tail.next = null;
        }
        else {
            head = null;
        }
        return p.value;
    }
    public T get(int index) {
        node p = head;
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
    private T dfs(node p, int index){
        if (p == null) {
            return null;
        }
        else if(index == 0) {
            return p.value;
        }
        return dfs(p.next, index-1);
    }
    public T getRecursive(int index) {
        return dfs(head, index);
    }
}
