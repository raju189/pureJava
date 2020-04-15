package arrays.sort;

/**
 * In-place algorithm
 * 
 * O(n2) time complexity - quadratic
 * 
 * It will take 100 steps to sort 10 items
 * 
 * Algorithm degrades quickly
 * 
 * Stable Sort Algorithm
 * 
 * @author G_disgreat
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] array = { 34, 23, 42, 55, 43, 66, -1 };
		bubbleSort(array);
		for (int i : array)
			System.out.println(i);
	}

	public static void bubbleSort(int[] unSortedArray) {
		for (int i = unSortedArray.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (unSortedArray[j] > unSortedArray[j + 1]) {
					swap(unSortedArray, j, j + 1);
				}
			}
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
