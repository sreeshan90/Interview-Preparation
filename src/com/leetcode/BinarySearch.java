import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 5, 2, 5, 3, 5, 3 };

		int key = 3;

		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		int index = -1;
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {

			int mid = (low + high) / 2;
			if (arr[mid] == key) {

				index = mid;
				break;
			} else if (key < arr[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}

		System.out.println(index);
		
	}

}
