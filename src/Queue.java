

public class Queue <T> extends SLL<T> {
    public Queue(){
        super();
    }
    public void enqueue(T item){
        add(item);   
    }
    public T dequeue(){
        return remove(0);
    }
    public T peek(){
        return get(0);
    }
    public int size(){ return super.size();}
    
    public boolean isEmpty(){
        if(size() == 0) return true;
        else return false;
    }   

    
}


