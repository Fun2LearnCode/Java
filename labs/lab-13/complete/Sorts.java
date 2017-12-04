import java.util.Arrays;

public class Sorts {
	public static void main(String args[]) {
		int[] list = new int[10];
		randomizeArray(list);
		insertionSort(list);
		System.out.println(Arrays.toString(list));
	}

	public static void bubbleSort(int[] list) { // improve on this bubble sort
		for (int x = 0; x < list.length - 1; x++) {
			if (list[x] > list[x + 1]) {
				swap(list, x, x + 1);
				if (x > 0) {
					x = x - 2;
				} else {
					x--;
				}
			}
		}
	}

	public static void insertionSort(int[] list) {
		int index;
		for (int x = 1; x < list.length; x++) {
			index = x;
			while (index > 0 && list[index - 1] > list[index]) {
				swap(list, index, --index);
			}
		}
	}

	public static void selectionSort(int[] list) {
		int min;
		for (int x = 0; x < list.length; x++) {
			min = x;
			for (int y = x + 1; y < list.length; y++) {
				if (list[min] > list[y]) {
					min = y;
				}
			}
			if (min != x) {
				swap(list, min, x);
			}
		}
	}

	public static void randomizeArray(int[] list) {
		for (int x = 0; x < list.length; x++) {
			list[x] = (int) (Math.random() * 10);
		}
	}

	public static void swap(int[] list, int index, int index2) {
		int x = list[index];
		list[index] = list[index2];
		list[index2] = x;
	}

}
