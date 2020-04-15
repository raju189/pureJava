package arrays.sort;

/**
 * In place algorithm
 * 
 * O(n2) time complexity - quadratic
 * 
 * it will take 100 steps to start 10 items
 * 
 * Doesn't required as much swapping as bubble sort
 * 
 * Unstable algorithm
 * 
 * @author G_disgreat
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] array = { 34, 23, 42, 55, 43, 66, -1 };
		selectionSort(array);
		for (int i : array)
			System.out.println(i);
	}

	public static void selectionSort(int[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			int largest = 0;
			for (int j = 1; j <= i; j++) {
				if (array[j] > array[largest]) {
					largest = j;
				}
			}
			swap(array, largest, i);
		}
	}

	static void swap(int[] array, int i, int j) {
		if (i == j) {
			return;
		}

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
