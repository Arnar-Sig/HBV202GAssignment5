package is.hi.hbv202g.ass5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IntStackTest {

    private IntStack stack;

    @Before
    public void createStackObject(){
        stack = new IntStack();
    }

    @Test
    public void testNewStackIsNotFull() {
        assertFalse(stack.isFull());
    }

    @Test
    public void testFullStackIsFull(){
        for (int i = 0; i < stack.getCapacity(); i++) {
            stack.push(i);
        }
        assertTrue(stack.isFull());
    }

    @Test
    public void testOneLessThanFullStack(){
        for (int i = 0; i < stack.getCapacity()-1 ; i++) {
            stack.push(i);
        }
        assertFalse(stack.isFull());
    }

    @Test
    public void testPopReturnsPushedValue(){
        int p = 5;
        stack.push(p);
        assertEquals(p, stack.pop());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testPopOnEmptyStack(){
        stack.pop();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testPushOnFullStack(){
        for (int i = 0; i < stack.getCapacity(); i++) {
            stack.push(i);
        }
        stack.push(1);
    }

    @Test
    public void testIsEmptyOnEmptyStack(){
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmptyOnNotEmptyStack(){
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

}
