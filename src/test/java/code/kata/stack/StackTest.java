package code.kata.stack;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StackTest {
    @Test
    public void testStackCreation() {
        Stack<Object> stack = new Stack();
    }

    @Test
    public void testPushToStack() {
        Stack<Integer> stack = new Stack();
        stack.push(10);
    }

    @Test(expected = RuntimeException.class)
    public void testPopFromEmptyStack() {
        Stack<Integer> stack = new Stack();
        stack.pop();
    }

    @Test
    public void testPopFromNonEmptyStack() {
        try {
            Stack<Integer> stack = new Stack();
            stack.push(10);
            stack.pop();
        } catch (Exception e) {
            Assert.fail("Pop should not fail on non-empty stack");
        }
    }

    @Test
    public void testPushToAndPopFromStack() {
        Integer element = 10;
        Stack<Integer> stack = new Stack();
        stack.push(element);
        Assert.assertEquals(element, stack.pop());
    }

    @Test
    public void testPushToAndPopFromStackWithRandomData() {
        Integer element = (int) (Math.random() * 10);
        Stack<Integer> stack = new Stack();
        stack.push(element);
        Assert.assertEquals(element, stack.pop());
    }

    @Test
    public void testMultiplePushAndPop() {
        Stack<Integer> stack = new Stack();
        new Random().ints(10).forEach(e -> stack.push(e));
        for(int i = 0 ; i < 10 ; i++) {
            stack.pop();
        }
    }

    @Test
    public void testMultiplePushAndPopWithOrder() {
        Stack<Integer> stack = new Stack();
        int[] elements = new Random().ints(10).toArray();
        for(int element : elements) {
            stack.push(element);
        }
        for(int i = elements.length - 1 ; i >= 0 ; i--) {
            Assert.assertEquals(Integer.valueOf(elements[i]), stack.pop());
        }
    }

    @Test
    public void testLargeNumberOfPushAndPopWithOrder() {
        Stack<Integer> stack = new Stack();
        int[] elements = new Random().ints(1000 * 1000).toArray();
        for(int element : elements) {
            stack.push(element);
        }
        for(int i = elements.length - 1 ; i >=0 ; i--) {
            Assert.assertEquals(Integer.valueOf(elements[i]), stack.pop());
        }
    }

    @Test(expected = RuntimeException.class)
    public void testPopMoreThanPush() {
        Stack<Integer> stack = new Stack();
        stack.push(10);
        Assert.assertEquals(Integer.valueOf(10), stack.pop());
        stack.pop();
        Assert.fail();
    }

    @Test
    public void testStackWithStringType() {
        Stack<String> stack = new Stack();
        new Random()
                .ints(1, 10)
                .limit(10)
                .forEach(e -> stack.push(RandomStringUtils.randomAlphanumeric(e)));
        for(int i = 0 ; i < 10; i++) {
            stack.pop();
        }
    }

    @Test
    public void testStackWithStringInOrder() {
        Stack<String> stack = new Stack<>();
        List<String> input = new ArrayList<>();
        new Random()
                .ints(1, 10)
                .limit(1000)
                .forEach(e -> input.add(RandomStringUtils.randomAlphanumeric(e)));
        for(String element : input) {
            stack.push(element);
        }
        for(int i = input.size() - 1 ; i >= 0 ; i--) {
            Assert.assertEquals(input.get(i), stack.pop());
        }
    }

}
