import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test {

	public static void main(String[] args) {
		int array[] = new int[10];
		int count =0;
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
		minHeap m = new minHeap();
		m.MinHeapSort(array, n);
		
		System.out.println("");
		m.printArray(array, n);
		// TODO Auto-generated method stub

	}

}
