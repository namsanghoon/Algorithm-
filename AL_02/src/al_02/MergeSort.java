package al_02;

public class MergeSort {
	public static int[] sorted = new int[10000];
	
	//merge메소드
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

	}
	// sort 메소드
	public void sort(int arr[], int m, int n, int x) { // x는 원소 몇개까지 쪼갤 것인지를 나타냄
		if (m + x < n) {
			// 중간 값 설정
			int middle = (m + n) / 2;
			// x의 원소 갯수가 될때까지 middle을 기준으로 계속해서 쪼개 나감
			sort(arr, m, middle, x);
			sort(arr, middle + 1, n, x);
			merge(arr, m, middle, n);
		}
	}
	// 쪼갠 원소들을 삽입정렬을 이용하여 정렬하는 메소드
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
			h = 0;
		}

	}
	//삽입정렬
	public static void insertsort(int[] array) {
		for (int i = 1; i < array.length; i++) {

			int standard = array[i]; // 기준

			int aux = i - 1; // 비교할 대상

			while (aux >= 0 && standard < array[aux]) {

				array[aux + 1] = array[aux]; // 비교대상이 큰 경우 오른쪽으로 밀어냄

				aux--;
			}
			array[aux + 1] = standard; // 기준값 저장

		}

	}

	

}
