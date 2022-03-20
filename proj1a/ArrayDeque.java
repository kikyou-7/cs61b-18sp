public class ArrayDeque<T> {
    T[] items;
    int size,p1,p2;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        p1 = p2 = 0;
    }
    public ArrayDeque(ArrayDeque<T> other) {
        items = (T[]) new Object[other.size];
        size = other.size;
        p1 = other.p1;
        p2 = other.p2;
        System.arraycopy(other.items, 0, items, 0, size);
    }
    public boolean isEmpty() {
        return p1 == p2;
    }
    private void resize() {
        items = (T[]) new Object[size*2];
        size *= 2;
    }
    public void addFirst(T item) {
        if ((p1 - 1 + size) % size == p2) {
            resize();
        }
        items[p1] = item;
        p1 = (p1 - 1 + size) % size;
    }
    public void removeFirst() {
        if (!isEmpty()) {
            p1 = (p1 + 1 + size) % size;
        }
    }
    public void addLast(T item) {
        if ((p2 + 1 + size) % size == p1) {
            resize();
        }
        p2 += 1;
        items[p2] = item;
    }
    public T removeLast() {
        if (!isEmpty()) {
            p2 = (p2 - 1 + size) % size;
        }
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        int t1 = p1, t2 = p2;
        while (t2 != t1) {
            System.out.print(items[t2]);
            t2 = (t2 -1 + size) % size;
        }
        System.out.println("");
    }
    public T get(int index) {
        int to = p1;
        for(int i = 0; i <= index; i++) {
            to = (to + 1 + size) % size;
            if (to == p2 + 1) {
                to = -1;
                break;
            }
        }
        if (to == -1) {
            return null;
        }
        return items[to];
    }
}
