import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class test {
	
	public static void main(String[] args) {

		int array[] = new int[100];
		int count = 0;
		int n = array.length;
		try {
			File file = new File("C://test_100.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while((line = bufReader.readLine()) != null) { //한 줄씩 읽어들여
				int number = Integer.parseInt(line);//정수형으로 캐스팅하고
				array[count] = number;//배열에 추가
				count++;
				}
				bufReader.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}
		/*//MinHeap
		minHeap m = new minHeap();
		m.MinHeapSort(array, n);*/
		
		/*//MaxHeap
		maxHeap x = new maxHeap();
		x.MaxHeapSort(array, n);
		System.out.println("");
		x.print(array, n);*/

		//CountSort
		System.out.println("Before : ");
		for(int i=0;i<array.length-1;i++) {
			System.out.println(array[i]);
		}
		System.out.println();
		CountingSort quickSort = new CountingSort();
		int max = quickSort.findMaxNumber(array);
		System.out.println(max);
		array = quickSort.sort(array, max);
		System.out.println("After : ");
		System.out.println(Arrays.toString(array));
		System.out.println();

		// TODO Auto-generated method stub

	}

}
