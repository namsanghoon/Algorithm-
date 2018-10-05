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

		System.out.println("\n �պ� ���� : >> ");
		printArr(arr);
	}

	public void sort(int arr[], int m, int n) {
		if (m + 2 < n) {
			// Find the middle point
			int middle = (m + n) / 2;
			// Sort first and second halves

			sort(arr, m, middle);
			sort(arr, middle + 1, n);
			/*partition(arr,2);*/
			merge(arr, m, middle, n);
		}
	}
	/*public void MergeAftersort(int arr[],int m,int n) {
		if (m + 2 < n) {
			// Find the middle point
			int middle = (m + n) / 2;
			sort(arr, m, middle);
			sort(arr, middle + 1, n);
			merge(arr, m, middle, n);
		}
	}*/
	

	public static void partition(int array[], int x) {
		int[] temp = new int[x];
		int k = 0;
		int a = 0;
		int h = 0;
		while (k < array.length - 1) {
			for (int j = k; j < k + x; j++) {
				temp[a] = array[j];
				a++;
			}
			insertsort(temp);
			for (int j = k; j < k + x; j++) {
				array[j] = temp[h];
				h++;
			}
			k = k + x;
			a = 0;
			h=0;
		}

	}

	public static void insertsort(int[] array) {
		for (int i = 1; i < array.length; i++) {

			int standard = array[i]; // ����

			int aux = i - 1; // ���� ���

			while (aux >= 0 && standard < array[aux]) {

				array[aux + 1] = array[aux]; // �񱳴���� ū ��� ���������� �о

				aux--;
			}
			array[aux + 1] = standard; // ���ذ� ����

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
