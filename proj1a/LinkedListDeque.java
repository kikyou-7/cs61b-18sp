public class LinkedListDeque<type> {
    private class node{
        public type value;
        public node pre,next;
        public node(type item, node pre, node next){
            this.value = item;
            this.pre = pre;
            this.next = next;
        }
    }

    public node head, tail;
    public int size;

    public LinkedListDeque(){
        head = tail = null;
        size = 0;
    }
    public void addFirst(type item){
        this.head = new node(item, null, this.head);
        size += 1;
    }
    public void addLast(type item){
        this.tail = new node(item, this.tail, null);
        size += 1;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return this.size;
    }
    public void printDeque(){
        node p = head;
        while(p != null){
            System.out.print(p.value + " ");
            p = p.next;
        }
    }
    public type removeFirst(){
        if(head == null){
            return null;
        }
        size -= 1;
        node p = head;
        head = head.next;
        if(head != null) head.pre = null;
        return p.value;
    }
    public type removeLast(){
        if(tail == null){
            return null;
        }
        size -= 1;
        node p = tail;
        tail = tail.pre;
        if(tail != null) tail.next = null;
        return p.value;
    }
    public type get(int index){
        node p = head;
        while(index != 0 && p != null){
            index--;
            p = p.next;
        }
        if(p == null){
            return null;
        }
        else {
            return p.value;
        }
    }
    private type dfs(node p,int index){
        if(p == null) {
            return null;
        }
        else if(index == 0){
            return p.value;
        }
        return dfs(p.next, index-1);
    }
    public type getRecursive(int index){
        return dfs(head, index);
    }
}
