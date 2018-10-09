package minHeap;

public class testMinHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 3, 1, 5, 9, 6, 4, 8, 0, 2, 7 };
		minHeap m = new minHeap(a);
        System.out.println("====순환적 minHeap====");
		System.out.print("Heapify 메소드 호출 Index : ");
		m.build_recu_min_heap(a, 0, 10);
		System.out.println("");
		m.level_order(a);
		int b[] = { 3, 1, 5, 9, 6, 4, 8, 0, 2, 7 };
		System.out.println("");
		System.out.println("====반복적 minHeap====");
		System.out.print("Heapify 메소드 호출 Index : ");
		m.build_iter_min_heap(b, 4, 10);
		System.out.println("");
		m.level_order(b);
		
		
	}
}
