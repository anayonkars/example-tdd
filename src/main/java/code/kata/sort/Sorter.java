package code.kata.sort;

public class Sorter {
    public int[] sort(int[] input) {
        if(input == null) {
            return null;
        } else if(input.length == 0 || input.length == 1) {
            return input;
        } else return sort(input, 0, input.length - 1);
    }
    private int[] sort(int[] input, int start, int end) {
         if(input.length == 2) {
            if(input[0] <= input[1]) {
                return input;
            }
            int[] result = new int[2];
            result[0] = input[1];
            result[1] = input[0];
            return result;
        } else {
            int pivot = input[(start + end) / 2];
            int i = start;
            int j = end;
            while(i <= j) {
                while (input[i] < pivot) i++;
                while (input[j] > pivot) j--;
                if(i <= j) {
                    swap(input, i, j);
                    i++;
                    j--;
                }
            }
            if(start < j) {
                sort(input, start, j);
            }
            if(i < end) {
                sort(input, i, end);
            }

            /*for(int i = 0 ; i < input.length ; i++) {
                for(int j = 0 ; j < input.length - 1 ; j++) {
                    if(input[j] > input[j+1]) {
                        swap(input, j, j+1);
                    }
                }
            }*/
        }
        return input;
    }

    private void swap(int[] input, int i , int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
