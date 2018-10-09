package minHeap;

public class minHeap {
	private int array[];

	public minHeap(int[] array) { // minHeap을 위한 배열 생성자
		this.array = array;
	}

	public void heapify(int[] b, int index, int n) { // heapify메소드

		System.out.print(index + " "); // heapify를 호출한 index 출력

		int temp = b[index];
		while (index < n / 2) { // index번의 노드가 리프노드가 아닌 동안

			int y = 2 * index + 1; // index번째 자식의 왼쪽 자식의 인덱스를 y라 한다

			if (y + 1 < n) { // index번째 자식의 오른쪽 자식이 존재하는 경우
				if (b[y] > b[y + 1]) { // 두개의 자식중 더 작은 것의 인덱스를 y라 한다
					y++;
				}
			}
			if (temp <= b[y]) // 자식이 더 큰경우 minHeap을 만족하기때문에 break
				break;
			b[index] = b[y]; // index자리에 y번의 원소를 옮긴다
			index = y; // index에 y를 넣는다
		}
		b[index] = temp; // index번째 자리에 temp값 저장
	}

	public void build_recu_min_heap(int[] b, int index, int n) {

		if (index >= n / 2) // index번째 노드가 자식이 없는 경우 return
			return;
		build_recu_min_heap(b, 2 * index + 1, n); // 왼쪽 자식에 대한 함수 호출
		build_recu_min_heap(b, 2 * index + 2, n); // 오른쪽 자식에 대한 함수 호출
		heapify(b, index, n); // index번째에 대해서 heapify호출
	}

}
