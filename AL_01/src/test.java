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
		//�ؽ�Ʈ ���� �о����
		try {
			File file = new File("C://test_100.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while((line = bufReader.readLine()) != null) { //�� �پ� �о�鿩
				int number = Integer.parseInt(line);//���������� ĳ�����ϰ�
				list.add(number);//list�� �߰�
				array[count] = number;//�迭�� �߰�
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
