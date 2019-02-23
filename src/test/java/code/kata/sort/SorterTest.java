package code.kata.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class SorterTest {
    @Test
    public void testNullSort() {
        Sorter sorter = new Sorter();
        Assert.assertNull(sorter.sort(null));
    }

    @Test
    public void testEmptySort() {
        Sorter sorter = new Sorter();
        int[] input = new int[0];
        int[] result = sorter.sort(input);
        assertArraysEqual(result, input);
    }

    @Test
    public void testSingleElementSort() {
        Sorter sorter = new Sorter();
        int[] input = new int[]{1};
        int[] result = sorter.sort(input);
        assertArraysEqual(result, input);
    }

    @Test
    public void testTwoElementSort() {
        Sorter sorter = new Sorter();
        int[] input = new int[]{2,1};
        int[] result = new int[]{1,2};
        assertArraysEqual(result, sorter.sort(input));
    }

    @Test
    public void testMultipleElementsSort() {
        Sorter sorter = new Sorter();
        //List<Integer> input = new Random().ints(10).boxed().collect(Collectors.toList());
        int input[] = new Random().ints(10).toArray();
        int[] result = sorter.sort(input);
        for(int i = 0 ; i < result.length - 1 ; i++) {
            Assert.assertTrue(result[i] <= result[i+1]);
        }
    }

    @Test
    public void testLargeNumberOfElementsSort() {
        Sorter sorter = new Sorter();
        //List<Integer> input = new Random().ints(10).boxed().collect(Collectors.toList());
        int input[] = new Random().ints(50000).toArray();
        int[] result = sorter.sort(input);
        for(int i = 0 ; i < result.length - 1 ; i++) {
            Assert.assertTrue(result[i] <= result[i+1]);
        }
    }

    @Test
    public void testVeryLargeNumberOfElementsSort() {
        Sorter sorter = new Sorter();
        //List<Integer> input = new Random().ints(10).boxed().collect(Collectors.toList());
        int input[] = new Random().ints(1000 * 1000).toArray();
        int[] result = sorter.sort(input);
        for(int i = 0 ; i < result.length - 1 ; i++) {
            Assert.assertTrue(result[i] <= result[i+1]);
        }
    }

    private void assertArraysEqual(int[] expected, int[] actual) {
        if(expected == null && actual == null) {
            return;
        }
        if(expected == null || actual == null) {
            Assert.fail("different arrays");
        }
        if(expected.length != actual.length) {
            Assert.fail("different arrays");
        }
        if(expected.length == 0) {
            return;
        }
        for(int i = 0 ; i < expected.length ; i++) {
            Assert.assertEquals(expected[i], actual[i]);
        }
    }
}
