package countingSort;
import java.util.Random;
import java.util.Scanner;

public class CountingSort {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Random r = new Random();
		int range = 0;
		
		
		System.out.println("Enter the size of the array: ");
		int a[] = new int[keyboard.nextInt()];
		int c[] = new int[a.length];
		
		System.out.println("Enter the range of the array values: ");
		range = keyboard.nextInt();
		
		System.out.printf("\nWe will creat an array of length %d and ranging from 0 - %d.\n", a.length, range);
		
		for (int i = 0; i < a.length; i++) { //This is for free, populating the array
			a[i] = r.nextInt(range + 1);
		}
		
		System.out.println("\nHere is your unsorted array:");
		print(a);
		
		System.out.printf("\n\nWe have created a new array with the size of the higest value in the range which is %d.\n", range);
		int b[] = new int[range + 1]; 	// creat temp array to hold the count values
										// The + 1 is for array values 0 - k
		
		for(int i = 0; i < a.length; i++) { //count number of time each values appears in the array
			++b[a[i]];
		}
		System.out.printf("\nHere is the counted array that has gone through %d iterations.\n", a.length);
		print(b);
		
		for(int i = 1; i < b.length; i++) { // sum up the prefix values for the location indices for sorted array.
			b[i] += b[i - 1];
		}
		System.out.printf("\n\nHere is the prefix sum array that has gone through %d iterations.\n", a.length);
		print(b);
		
		for(int i = (a.length - 1); i >= 0; i--) { //populate the array in a sorted order
			c[--b[a[i]]] = a[i];
		}
		
		a = c; // set refference from c to a
		
		System.out.printf("\n\nHere is you sorted array that has gone through %d iterations.\n", a.length);
		print(a);
	}

	/**
	 * Print the elements of an array
	 * @param array	The array of which the elements are to be printed.
	 */
	private static void print(int array[]) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}