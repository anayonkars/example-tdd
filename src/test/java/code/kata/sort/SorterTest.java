package code.kata.sort;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SorterTest {
    @Test
    public void testNullSort() {
        Sorter sorter = new Sorter();
        Assert.assertNull(sorter.sort(null));
    }

    @Test
    public void testEmptySort() {
        Sorter<Integer> sorter = new Sorter();
        Integer[] input = new Integer[0];
        Integer[] result = sorter.sort(input);
        assertArraysEqual(result, input);
    }

    @Test
    public void testSingleElementSort() {
        Sorter<Integer> sorter = new Sorter();
        Integer[] input = new Integer[]{1};
        Integer[] result = sorter.sort(input);
        assertArraysEqual(result, input);
    }

    @Test
    public void testTwoElementSort() {
        Sorter<Integer> sorter = new Sorter();
        Integer[] input = new Integer[]{2,1};
        Integer[] result = new Integer[]{1,2};
        assertArraysEqual(result, sorter.sort(input));
    }

    @Test
    public void testMultipleElementsSort() {
        Sorter<Integer> sorter = new Sorter();
        //List<Integer> input = new Random().ints(10).boxed().collect(Collectors.toList());
        int[] array = new Random().ints(10).toArray();
        Integer[] input = Arrays.stream(array).boxed().toArray(Integer[]::new);
        Integer[] result = sorter.sort(input);
        assertArraySorted(result);
    }

    @Test
    public void testLargeNumberOfElementsSort() {
        Sorter<Integer> sorter = new Sorter();
        //List<Integer> input = new Random().ints(10).boxed().collect(Collectors.toList());
        int array[] = new Random().ints(50000).toArray();
        Integer[] input = Arrays.stream(array).boxed().toArray(Integer[]::new);
        Integer[] result = sorter.sort(input);
        assertArraySorted(result);
    }

    @Test
    public void testVeryLargeNumberOfElementsSort() {
        Sorter<Integer> sorter = new Sorter();
        //List<Integer> input = new Random().ints(10).boxed().collect(Collectors.toList());
        int array[] = new Random().ints(1000 * 1000).toArray();
        Integer[] input = Arrays.stream(array).boxed().toArray(Integer[]::new);
        Integer[] result = sorter.sort(input);
        assertArraySorted(result);
    }

    @Test
    public void testStringSorting() {
        Sorter<String> sorter = new Sorter<>();
        Object[] array = new Random()
                .ints(1, 10)
                .limit(10)
                .mapToObj(e -> RandomStringUtils.randomAlphanumeric(e))
                .toArray();
        String[] input = Arrays.stream(array).toArray(String[]::new);
        String[] result = sorter.sort(input);
        assertArraySorted(result);
    }

    @Test
    public void testStringSortingForLargeInput() {
        Sorter<String> sorter = new Sorter<>();
        Object[] array = new Random()
                .ints(1, 10)
                .limit(1000)
                .mapToObj(e -> RandomStringUtils.randomAlphanumeric(e))
                .toArray();
        String[] input = Arrays.stream(array).toArray(String[]::new);
        String[] result = sorter.sort(input);
        assertArraySorted(result);
    }

    private void assertArraysEqual(Object[] expected, Object[] actual) {
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

    private <T extends Comparable<T>> boolean assertArraySorted(T[] array) {
        if(array == null) {
            return true;
        }
        if(array.length == 0 || array.length == 1) {
            return true;
        }
        for(int i = 0 ; i < array.length - 1 ; i++) {
            if(array[i].compareTo(array[i+1]) <= 0) {
                continue;
            }
            return false;
        }
        return true;
    }
}
