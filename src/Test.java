import java.util.*;
  
public class Test {
  
    public static void main(String args[])
    {
        // Creating object of the
        // class linked list
        LinkedList<String> ll
            = new LinkedList<String>();
  
        // Adding elements to the linked list
        ll.add("A");
       
  
        ll.remove(0);
      
        ll.removeFirst();
        ll.removeLast();
  
        System.out.println(ll);
    }
}