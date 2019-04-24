package datastructure;

public class LinkedList<T> {
    T value;
    LinkedList<T> next;

    public LinkedList(T value){
        this.value = value;
        next = null;
    }
    public LinkedList<T> getNext(){
        return next;
    }

    public T getValue(){
        return value;
    }

    public void add(LinkedList node){
        if (next == null) this.next = node;
        else {
            LinkedList<T> last = next;
            while (last.next != null) last = last.next;
            last.next = node;
        }

    }


}
