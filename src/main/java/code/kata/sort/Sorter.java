package code.kata.sort;

public class Sorter<T extends Comparable<T>> {
    public T[] sort(T[] input) {
        if(input == null) {
            return null;
        } else if(input.length == 0 || input.length == 1) {
            return input;
        } else return sort(input, 0, input.length - 1);
    }
    private T[] sort(T[] input, int start, int end) {
         if(input.length == 2) {
             if(input[0].compareTo(input[1]) <= 0) {
                return input;
            } else {
                 swap(input, 0, 1);
                 return input;
             }
        } else {
            T pivot = input[(start + end) / 2];
            int i = start;
            int j = end;
            while(i <= j) {
                while (input[i].compareTo(pivot) < 0) i++;
                while (input[j].compareTo(pivot) > 0) j--;
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

    private void swap(T[] input, int i , int j) {
        T temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
