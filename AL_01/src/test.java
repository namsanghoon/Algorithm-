import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class test {
	static DoubleLinkedList list = new DoubleLinkedList();
	static int array[] = new int[10000];
	static int count =0;
	static long start;
	static long end;
	public static void main(String args[]){
		//텍스트 파일 읽어오기
		try {
			File file = new File("C://test_100.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while((line = bufReader.readLine()) != null) { //한 줄씩 읽어들여
				int number = Integer.parseInt(line);//정수형으로 캐스팅하고
				list.add(number);//list에 추가
				array[count] = number;//배열에 추가
				count++;
				}
				bufReader.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
		/*list.BubbleSort(array);*/
		/*list.InsertionSort(array);*/
		/*list.SelectionSort(array);
		list.print();*/
	}
	
}
