import java.util.Arrays;
public class InsertionSort {
    public static void main(String[] args){
        int[] array = {9, 3, 1, 5, 6};
        System.out.println("Input: " + Arrays.toString(array));
        insertionSort(array);
        System.out.println("Output: " + Arrays.toString(array));
    }
    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}

