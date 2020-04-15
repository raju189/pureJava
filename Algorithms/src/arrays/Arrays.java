package arrays;

/**
 * Contiguous block in memory
 * 
 * Every element occupies the same amount of space in memory
 * 
 * x + i * y, i'th element, y is size, x is starting address.
 * 
 * Retrieve with index O(1) constant time; 
 * Retrieve without index O(n) liner time; 
 * Add an element to a full array O(n); 
 * Add an element to the end of an array (has space) O(1); 
 * insert or update an element at a specific index O(1);
 * Delete an element by setting it to null O(1); 
 * Delete an element by shifting element O(n);
 * 
 * Unstable Sort:
 * Duplicate element order will changed
 *  eg:   3, 4, 3, 5 -> 3,3,4,5 0th 3 will be 2th 3
 * Stable Sort:
 * Duplicate element order will not changed
 * eg:   3, 4, 3, 5 -> 3,3,4,5 0th 3 will be 0th 3, not change position.
 * @author G_disgreat
 *
 */
public class Arrays {

	public static void main(String[] args) {
		int[] array = new int[7];
		array[0] = 30;
		array[1] = 45;
		array[2] = 3;
		array[3] = 98;
		array[4] = 23;
		array[5] = 1;
		array[6] = 23;

		// Retrieve an Element from an Array
		getElemnetByindex(array, 6);
	}

	private static void getElemnetByindex(int[] array, int i) {
		// Multiply the size of the element by its index
		// eg: int is 4 bytes
		// Get the start address of the array
		// eg: suppose zero'th element at 38 address
		// Add the start address to the result of the multiplication
		// eg: address + i * size

		System.out.println("Element is " + array[i]);

	}

}
