
public class CountingSort {
	public int[] sort(int[] arr, int maxNumber) {

		int[] countData = new int[maxNumber + 1]; //0-maxNumber+1만큼 생성
		for (int i = 0; i < arr.length; i++) {// 등장 횟수 저장
			countData[arr[i]]++;
		}
		for (int i = 1; i < countData.length; i++) {  //누적 숫자 더하기
			countData[i] += countData[i - 1];
		}
		int[] sortedData = new int[arr.length];  //정렬하기
		for (int i = arr.length - 1; i >= 0; i--) {
			sortedData[countData[arr[i]] - 1] = arr[i];
			countData[arr[i]]--;
		}
		return sortedData;
	}

	int findMaxNumber(int[] a) {// 최댓값 찾기
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}

}
