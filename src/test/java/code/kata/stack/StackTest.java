package code.kata.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class StackTest {
    @Test
    public void testStackCreation() {
        Stack stack = new Stack();
    }

    @Test
    public void testPushToStack() {
        Stack stack = new Stack();
        stack.push(10);
    }

    @Test(expected = RuntimeException.class)
    public void testPopFromEmptyStack() {
        Stack stack = new Stack();
        stack.pop();
    }

    @Test
    public void testPopFromNonEmptyStack() {
        try {
            Stack stack = new Stack();
            stack.push(10);
            stack.pop();
        } catch (Exception e) {
            Assert.fail("Pop should not fail on non-empty stack");
        }
    }

    @Test
    public void testPushToAndPopFromStack() {
        int element = 10;
        Stack stack = new Stack();
        stack.push(element);
        Assert.assertEquals(element, stack.pop());
    }

    @Test
    public void testPushToAndPopFromStackWithRandomData() {
        int element = (int) (Math.random() * 10);
        Stack stack = new Stack();
        stack.push(element);
        Assert.assertEquals(element, stack.pop());
    }

    @Test
    public void testMultiplePushAndPop() {
        Stack stack = new Stack();
        new Random().ints(10).forEach(e -> stack.push(e));
        for(int i = 0 ; i < 10 ; i++) {
            stack.pop();
        }
    }

    @Test
    public void testMultiplePushAndPopWithOrder() {
        Stack stack = new Stack();
        int[] elements = new Random().ints(10).toArray();
        for(int element : elements) {
            stack.push(element);
        }
        for(int i = elements.length - 1 ; i >= 0 ; i--) {
            Assert.assertEquals(elements[i], stack.pop());
        }
    }

    @Test
    public void testStackWithSize() {
        Stack stack = new Stack();
    }

    @Test
    public void testLargeNumberOfPushAndPopWithOrder() {
        Stack stack = new Stack();
        int[] elements = new Random().ints(1000 * 1000).toArray();
        for(int element : elements) {
            stack.push(element);
        }
        for(int i = elements.length - 1 ; i >=0 ; i--) {
            Assert.assertEquals(elements[i], stack.pop());
        }
    }

    @Test(expected = RuntimeException.class)
    public void testPopMoreThanPush() {
        Stack stack = new Stack();
        stack.push(10);
        Assert.assertEquals(10, stack.pop());
        stack.pop();
        Assert.fail();
    }

}
