package al_02;

public class MergeSort {
	public static int[] sorted = new int[12];
	int count = 0;
	
	public void merge(int arr[], int m, int middle, int n) {
		int i, j, k, t;
		i = m;
		j = middle + 1;
		k = m;
		while (i <= middle && j <= n) {

			if (arr[i] <= arr[j])
				sorted[k] = arr[i++];
			else
				sorted[k] = arr[j++];
			k++;

		}
		if (i > middle) {
			for (t = j; t <= n; t++, k++)
				sorted[k] = arr[t];
		} else {
			for (t = i; t <= middle; t++, k++)
				sorted[k] = arr[t];
		}

		for (t = m; t <= n; t++) {
			arr[t] = sorted[t];
		}

		System.out.println("\n 합병 정렬 : >> ");
		printArr(sorted);
	}

	public int[] sort(int arr[], int m, int n) {
		
		
		if (m + 3 < n) {
			// Find the middle point
			int middle = (m + n) / 2;
			// Sort first and second halves
			
			insertion_srt(sort(arr, m, middle),middle);
			//sort(arr, );
			insertion_srt(sort(arr,middle + 1, n),n);
			// Merge the sorted halves
			merge(arr, m, middle, n);
		}
		return arr;
	}

	public static void insertion_srt(int array[], int n){
		  for (int i = 1; i < n; i++){
		  int j = i;
		  int B = array[i];
		  while ((j > 0) && (array[j-1] > B)){
		  array[j] = array[j-1];
		  j--;
		  }
		  array[j] = B;
		  }
		  }

	public void printArr(int[] arr) {
		// TODO Auto-generated method stu
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
