
public class CountingSort {
	public int[] sort(int[] arr, int maxNumber) {

		int[] countData = new int[maxNumber + 1]; //0-maxNumber+1��ŭ ����
		for (int i = 0; i < arr.length; i++) {// ���� Ƚ�� ����
			countData[arr[i]]++;
		}
		for (int i = 1; i < countData.length; i++) {  //���� ���� ���ϱ�
			countData[i] += countData[i - 1];
		}
		int[] sortedData = new int[arr.length];  //�����ϱ�
		for (int i = arr.length - 1; i >= 0; i--) {
			sortedData[countData[arr[i]] - 1] = arr[i];
			countData[arr[i]]--;
		}
		return sortedData;
	}

	int findMaxNumber(int[] a) {// �ִ� ã��
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}

}
