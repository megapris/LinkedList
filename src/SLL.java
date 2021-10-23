
//import javax.lang.model.element.Element;

public class SLL<E> {

    private Node<E> head;
    private int size;

    public SLL(){
        head = null;
        size = 0;
    }

    private class Node<E> {
        public E data;
        public Node<E> next;

        public Node(E data){
            this.data = data;
        }
    }
   

    public int size(){
        return this.size;
    }



    public void add(int index, E element){
        if(index > size)
            throw new IllegalArgumentException("Index out of bounds!");
        
        Node<E> tmp = new Node<E>(element);
        if(index == 0){
            tmp.next = head;
            head = tmp;
        } else {
            Node<E> prior = getNode(index - 1);
            tmp.next = prior.next;
            prior.next = tmp;
        }
        size++;
    }

    public E get(int index){
        if(index > size || index < -1)
            throw new IllegalArgumentException("Index out of bounds!");
        if(size != 0 ){
            return getNode(index).data;
        }
        return null;
    }

    private Node<E> getNode(int index){
        
        if(size != 0){
            if(index > size || index < -1)
            throw new IllegalArgumentException("Index out of bounds!");
        int count = 0;
        Node<E> current = head;
        while(count < index){
            current = current.next;
            count++;
        }
        return current;
        }
        else
            return null;
    }

    public boolean add(E data){
        Node<E> tmp = new Node<E>(data);
        tmp.next = null;
        if(head == null){
            head = tmp;
        } else {
            Node<E> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = tmp;
        }

        size++;
        return true;
    }

    public void clear(){
        head = null;
        size = 0;
        
    }

    public E remove(int index){
        if(head == null)
            throw new IllegalArgumentException("No items to remove!");
        if(index > size || index < -1)
            throw new IllegalArgumentException("Index out of bounds!");
        if(size != 0){
            Node <E> prev = getNode(index-1);
            Node <E> agarra = prev.next;
            prev.next = getNode(index).next;
                
            return agarra.data;
        }
        size--;
        return null;

    }

    public Boolean contains(E element){
        boolean answer = false;
        int count = 0;
        Node <E> current = head;
        Node <E> comparar = new Node<E>(element);
        
        while(count < size){
            if(current.data == comparar.data) answer = true;
            current = current.next;
            count++;
        }

        return answer;
    }

    public E set(int index, E element){
        if (index < 0 || index > size())
            throw new IllegalArgumentException("Index out of bounds!");
   
        Node <E> replace = new Node<E>(element);
        Node <E> nextNode = getNode(index+1);
        Node <E> current = getNode(index);
        Node <E> catchNode = current;

        current.data = replace.data;
        current.next = nextNode;

        return catchNode.data;
    }
    public Object[] toArray(){
        Object[] myArray = new Object[size];
        Node <E> current = head;

        for(int i = 0; i < size; i++){
            myArray[i] = current.data;
            current = current.next;
        }

        return myArray;
    }

    public static void main(String[] args){
        SLL<String> names = new SLL<String>();
        names.add("jefe");
        names.add("jhayco");

        Object[] myarray =  names.toArray();
        String[] compareArray = new String[]{"jefe", "jhayco"};

        for(int i = 0; i < myarray.length; i++){
            System.out.println(myarray[i]);
        }
        for(int i = 0; i < compareArray.length; i++){
            System.out.println(compareArray[i]);
        }

    }

}