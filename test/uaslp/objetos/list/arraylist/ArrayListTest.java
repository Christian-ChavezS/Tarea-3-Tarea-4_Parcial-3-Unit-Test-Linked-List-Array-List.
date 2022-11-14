package uaslp.objetos.list.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import uaslp.objetos.list.Iterator;



public class ArrayListTest {


    @Test
    public void givenANewList_thenSizeIsZero(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();

        //When:
        int size = lista.getSize();

        //Then:
        Assertions.assertEquals(0, size);
    }

    @Test
    public void givenANewList_whenAddAtTail_thenSizeIsOne(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();

        //When:
        lista.addAtTail("Uno");

        //Then:
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals("Uno", lista.getAt(0));
    }

    @Test
    public void givenANonEmptyList_whenAddAtTail_thenSizeIsIncreased(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();
        lista.addAtTail("Uno");

        //When:
        lista.addAtTail("Dos");

        //Then:
        Assertions.assertEquals(2, lista.getSize());
        Assertions.assertEquals("Uno", lista.getAt(0));
        Assertions.assertEquals("Dos", lista.getAt(1));
    }

    @Test
    public void givenANewList_whenAddAtFront_thenSizeIsOne(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();

        //When:
        lista.addAtFront("Uno");

        //Then:
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals("Uno", lista.getAt(0));
    }

    @Test
    public void givenANonEmptyList_whenAddAtFront_thenSizeIsIncreased(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();
        lista.addAtFront("Uno");

        //When:
        lista.addAtFront("Dos");

        //Then:
        Assertions.assertEquals(2, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
    }

    @Test
    public void givenAList_whenRemoveLessThanZero_thenReturnFalse(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();
        lista.addAtFront("Uno");

        //When:
         boolean result = lista.remove(-1);

        //Then:
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAListWithOneElement_whenRemoveHead_thenReturnTrue(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();
        lista.addAtFront("Uno");

        //When:
        boolean result = lista.remove(0);

        //Then:
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, lista.getSize());
    }

    @Test
    public void givenAListWithTwoElements_whenRemoveHead_thenReturnTrue(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();
        lista.addAtFront("Uno");
        lista.addAtFront("Dos");

        //When:
        boolean result = lista.remove(0);

        //Then:
        Assertions.assertTrue(result);
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Uno");
    }

    //Falta el coverage de removeTail en la funcion Remove
    @Test
    public void givenAListWithTwoElements_whenRemoveTail_thenReturnTrue(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();
        lista.addAtFront("Uno");
        lista.addAtFront("Dos");

        //When:
        boolean result = lista.remove(1);

        //Then:
        Assertions.assertTrue(result);
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Dos");
        Assertions.assertNull(lista.getAt(1));
    }

    @Test
    public void givenAListWith3Elements_whenRemoveMiddle_thenReturnTrue(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        boolean result = lista.remove(1);
        //2 3

        //Then:
        Assertions.assertTrue(result);
        Assertions.assertEquals(2, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Dos");
        Assertions.assertEquals(lista.getAt(1), "Tres");
    }

    @Test
    public void givenAListWith3Elements_whenRemoveAll_thenSizeIsZero(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        lista.removeAll();

        //Then:
        Assertions.assertEquals(0, lista.getSize());
    }

    @Test
    public void givenAListWith3Elements_whenSetAtOne_thenSuccess(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        lista.setAt(1, "Cuatro");
        // 2 4 3

        //Then:
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Cuatro", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
    }

    @Test
    public void givenAListWith3Elements_whenSetAtLessThan0_thenReturnNull(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        boolean result = lista.setAt(-1, "Cuatro");
        // 2 1 3

        //Then:
        Assertions.assertFalse(result);
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
    }

    @Test
    public void givenAListWith2Elements_whenAddAtFront_thenArrayIsIncreased(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        // 2 1


        //When:
        lista.addAtFront("Tres");
        // 3 2 1

        //Then:
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Tres", lista.getAt(0));
        Assertions.assertEquals("Dos", lista.getAt(1));
        Assertions.assertEquals("Uno", lista.getAt(2));
    }

    @Test
    public void givenAListWith3Elements_whenSetAtIndex3_thenReturnNull(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        boolean result = lista.setAt(3, "Cuatro");
        // 2 1 3

        //Then:
        Assertions.assertFalse(result);
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
    }

    @Test
    public void givenAListWith3Elements_whenGetAtLessThan0_thenReturnNull(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        String result = lista.getAt(-1);
        // 2 1 3

        //Then:
        Assertions.assertNull(result);
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
    }

    @Test
    public void givenAListWith3Elements_whenGetAtGreaterThanSize_thenReturnNull(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 1 3

        //When:
        String result = lista.getAt(3);

        //Then:
        Assertions.assertNull(result);
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
    }

    @Test
    public void givenAnEmptyList_whenRemoveAllWithValue_thenIndexZeroMustBeNull(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();

        //When:
        lista.removeAllWithValue("Uno");

        //Then:
        Assertions.assertEquals(0, lista.getSize());
        Assertions.assertNull(lista.getAt(0));
    }

    @Test
    public void givenAListWith5Elements_whenRemoveAllWithValue_thenDecreaseSize(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 2 1 3 3

        //When:
        lista.removeAllWithValue("Tres");
        // 2 2 1

        //Then:
        Assertions.assertEquals(3, lista.getSize()); //Para que esto funcionara, tuve que agregar la disminucion del size en la funcion removeAllWithValue porque este no se estaba disminuyendo al borrar los valores
        Assertions.assertEquals("Uno", lista.getAt(2));
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertNull(lista.getAt(3));
    }

    @Test
    public void givenAListWithNoCoincidences_whenRemoveAllWithValue_thenReturnTheSameList(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        // 2 2 1 3 3

        //When:
        lista.removeAllWithValue("Cuatro");
        // 2 2 1 3 3, queda igual

        //Then:
        Assertions.assertEquals(5, lista.getSize()); //Para que esto funcionara, tuve que agregar la disminucion del size en la funcion removeAllWithValue porque este no se estaba disminuyendo al borrar los valores
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Tres", lista.getAt(4));
    }

    @Test
    public void givenAListWith5Elements_whenRemoveAllWithValueClearsTheList_thenSizeIsZero(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();
        lista.addAtTail("Tres");
        lista.addAtFront("Tres");
        lista.addAtTail("Tres");
        lista.addAtFront("Tres");
        lista.addAtTail("Tres");
        // 2 2 1 3 3

        //When:
        lista.removeAllWithValue("Tres");
        // 2 2 1

        //Then:
        Assertions.assertEquals(0, lista.getSize()); // Aqui la lista deberia quedar vacia, por tanto size es 0 directamente
        Assertions.assertNull(lista.getAt(0));
    }

    @Test
    public void givenANonEmptyList_whenIterate_thenIterationIsSuccessfully(){
        //Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtFront("Tres");
        lista.addAtTail("Dos");
        lista.addAtTail("Uno");
        lista.addAtTail("Cuatro");
        // 3 2 1 4

        //When:
        Iterator<String> iterator = lista.getIterator();

        //Then:
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Tres", iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Dos", iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Uno", iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Cuatro", iterator.next());

        Assertions.assertFalse(iterator.hasNext());
    }


}
