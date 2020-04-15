package arrays.sort;

/**
 * In place algorithm
 * 
 * O(n*n) time complexity - quadratic
 * 
 * it will take 100 steps 10 items
 * 
 * Stable algorithm
 * 
 * @author G_disgreat
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] array = { 34, 23, 42, 55, 43, 66, -1 };
		insertionSort(array);
		for (int i : array)
			System.out.println(i);
	}

	static void insertionSort(int[] array) {
		for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
			int newElement = array[firstUnsortedIndex];

			int i;

			for (i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--) {
				array[i] = array[i - 1];
			}

			array[i] = newElement;
		}
	}

}
