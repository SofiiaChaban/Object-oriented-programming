import java.io.Serializable;
import java.util.Iterator;
public class MyList <T> implements Iterable<T>,Serializable {
    private class Node implements Serializable{
        private T info;
        private Node next;

        public T getInfo() {
            return info;
        }

        public void setInfo(T info) {
            this.info = info;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    private Node first;
    private int size;
    public int size(){
        return size;
    }
    public void clear(){
        first=new Node();
    }
    public void add(T info){
        Node initial = new Node();
        initial.setInfo(info);
        if(first!=null){
            Node temp = first;
            while((temp.getNext())!=null){
                temp=temp.getNext();
            }
            temp.setNext(initial);
        }
        else{
            first=initial;
        }
        size++;
    }
    public T get(int index){
        Node temp = first;
        int count = 0;
        while(temp!=null){
            if(count++ == index){
                return (T) temp.getInfo();
            }
            else{
                temp = temp.getNext();
            }
        }
        return null;
    }
    public boolean remove(int index){
        if(size<=0){
            return false;
        }
        Node temp = first;
        int counter=0;
        Node previous = null;
        while(temp!=null) {
            if (counter++ == index) {
                if (previous == null) {
                    first = temp.getNext();
                } else if (temp.getNext() == null) {
                    previous.setNext(null);
                } else {
                    previous.setNext(temp.getNext());
                }
                size --;
                return true;
            }
        }
        previous = temp;
        temp = temp.getNext();
        return false;
    }

    public T[] toArray(){
    T[] array;
        array = (T[]) new Object[size];
        for(int i = 0;i<size;i++){
        array[i]=get(i);
    }
    return array;
    }

    public String toString(){
    StringBuilder res = new StringBuilder();
    Node temp = first;
    while(temp!=null){
        res.append(temp.getInfo());
        temp = temp.getNext();
    }
    return new String(res);
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int counter;

            {
                counter = 0;
            }

            @Override
            public boolean hasNext() {
                return counter < size();
            }

            @Override
            public T next() {
                return get(counter++);
            }
        };
    }
}
