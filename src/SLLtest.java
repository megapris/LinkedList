
import  org.junit.Test;

import static org.junit.Assert.*;

public class SLLtest {
    
    @Test
    public void testConstructorInt(){
        SLL<Integer> nums = new SLL<Integer>();
        assertTrue(nums.size() == 0);
    }
    @Test
    public void testConstructorString(){
        SLL<String> names = new SLL<String>();
        assertTrue(names.size() == 0);
    }

    class Chelelo{
        private int loles = 5;
    }
    @Test
    public void testConstructorOwnClass(){
        Chelelo Pedro = new Chelelo();

        assertTrue(Pedro.loles == 5);
    }

    @Test 
    public void testAddInt(){
        SLL<Integer> nums = new SLL<Integer>();
        for(int i = 0; i < 100; i++){
            nums.add(1);
        }
        assertTrue(nums.size() == 100);
    }

    @Test
    public void testAddStr(){
        SLL<String> names = new SLL<String>();
        for(int i = 0; i < 100; i++){
            names.add("a");
        }
        assertTrue(names.size() == 100);
    }

    @Test
    public void testAddOwn(){
        SLL<Chelelo> names = new SLL<Chelelo>();
        Chelelo Pedro = new Chelelo();
        for(int i = 0; i < 100; i++){
            names.add(Pedro);
        }
        assertTrue(names.size() == 100);
    }

    @Test
    public void getTestNoItems(){
        SLL<String> names = new SLL<String>();
        assertTrue(names.get(0) == null);
    }
    @Test (expected = IllegalArgumentException.class)
    public void getTestNegIndex(){
        SLL<String> names = new SLL<String>();
        names.get(-3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getTestBigIndex(){
        SLL<String> names = new SLL<String>();
        names.add("a");
        names.add("a");
        names.add("a");
        names.add("a");

        names.get(6);
    }

    @Test
    public void getTest(){
        SLL<String> names = new SLL<String>();
        names.add("a");
        names.add("a");
        names.add("a");
        names.add("a");

        String tst = names.get(1);

        assertTrue(tst.equals("a"));
    }
    
    @Test
    public void addTestString(){
        SLL<String> names = new SLL<String>();
        names.add("julio");

        assertTrue(names.size() == 1 );
    }

    @Test
    public void addTestInt(){
        SLL<Integer> nums = new SLL<Integer>();
        nums.add(1);

        assertTrue(nums.size() == 1 );
    }

    @Test
    public void addTestCustomObj(){
        SLL<Chelelo> names = new SLL<Chelelo>();
        Chelelo Pedro = new Chelelo();
        names.add(Pedro);

        assertTrue(names.size() == 1 );
    }

    @Test
    public void addTestArray(){
        SLL<int[]> nums = new SLL<int[]>();
        int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        int[] intArray1 = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        int[] intArray2 = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        nums.add(intArray);
        nums.add(intArray1);
        nums.add(intArray2);

        assertTrue(nums.size() == 3);
    }

    @Test
    public void addTestNoItems(){
        SLL<String> names = new SLL<String>();
        names.add("jefe");

        assertTrue(names.size() == 1);
    }
    
    @Test
    public void addTest100(){
        SLL<String> names = new SLL<String>();
        for(int i = 0; i < 100; i++){
            names.add("jefe");
        }

        assertTrue(names.size() == 100);
    }

    @Test
    public void testClearNoElements(){
        SLL<String> names = new SLL<String>();
        names.clear();
        assertTrue(names.size() == 0);
    }
    @Test
    public void testClearOneElement(){
        SLL<String> names = new SLL<String>();
        names.add("hola");
        names.clear();
        assertTrue(names.size() == 0);
        
    }
    @Test
    public void testClear100Elements(){
        SLL<String> names = new SLL<String>();
        for(int i = 0; i < 100; i++){
            names.add("jefe");
        }
        names.clear();
        assertTrue(names.size() == 0);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testRemoveNegIndex(){
        SLL<String> names = new SLL<String>();
        names.remove(-5);

    }
    @Test (expected = IllegalArgumentException.class)
    public void testRemoveNoItems(){
        SLL<String> names = new SLL<String>();
        names.remove(0);

    }
    @Test
    public void testRemove(){
        SLL<String> names = new SLL<String>();
        names.add("jefe");
        names.add("tres");
        names.add("diez");

        String tst = names.remove(1);

        assertTrue(tst.equals("tres"));
    }
    @Test
    public void testRemoveSize(){
        SLL<String> names = new SLL<String>();
        names.add("jefe");
        names.add("tres");
        names.add("diez");

        names.remove(1);

        assertTrue(names.size() == 2);
    }
    @Test
    public void testContainsNoElements(){
        SLL<String> names = new SLL<String>();
        assertFalse(names.contains("hola"));
    }
    @Test
    public void testContainsWrongParameter(){
        SLL<String> names = new SLL<String>();
        names.add("Bad Bunny");
        assertFalse(names.contains("element"));
    }
    @Test 
    public void testContains(){
        SLL<String> names = new SLL<String>();
        names.add("Camilo");
        assertTrue(names.contains("Camilo"));
    }
    @Test  (expected = IllegalArgumentException.class)
    public void testSetNoElements(){
        SLL<String> names = new SLL<String>();
        String tst = names.set(0, "pollo");
        System.out.println(tst);
        assertTrue(tst.equals("pollo"));
    }
    @Test (expected = IllegalArgumentException.class)
    public void testSetNegIndex(){
        SLL<String> names = new SLL<String>();
        names.set(-5, "pollo");
    }
    @Test (expected = IllegalArgumentException.class)
    public void testSetBigIndex(){
        SLL<String> names = new SLL<String>();
        names.add("hola");
        names.set(2, "tres");
    }
    @Test
    public void setTest(){
        SLL<String> names = new SLL<String>();
        names.add("jefe");
        names.set(0,"benito");

        assertTrue(names.get(0).equals("benito"));
    }
    @Test
    public void testToString(){
        SLL<String> names = new SLL<String>();
        names.add("jefe");
        names.add("jhayco");

        Object[] myarray = names.toArray();
        String[] compareArray = new String[]{"jefe", "jhayco"};

        assertTrue(myarray[0].equals(compareArray[0]));
    }

}
