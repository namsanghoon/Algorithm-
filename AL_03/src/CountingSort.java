
public class CountingSort {
	public int[] sort(int[] data, int maxNumber) {

		int[] countData = new int[maxNumber + 1]; //0-maxNumber+1��ŭ ����
		for (int i = 0; i < data.length; i++) {
			countData[data[i]]++;
		}
		for (int i = 1; i < countData.length; i++) {  //���� ���� ���ϱ�
			countData[i] = countData[i - 1] + countData[i];
		}
		int[] sortedData = new int[data.length];  //�����ϱ�
		for (int i = data.length - 1; i >= 0; i--) {
			sortedData[countData[data[i]] - 1] = data[i];
			countData[data[i]]--;
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
