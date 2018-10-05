package al_02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	static MergeSort ms = new MergeSort();
	static QuickSort qs = new QuickSort();
	static int array[] = new int[8];
	static int count =0;
	public static void main(String args[]){
		//텍스트 파일 읽어오기
		try {
			File file = new File("C://test_8.txt");
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
		/*for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+ " ");
		}*/
		ms.partition(array, 2);
		ms.sort(array, 0, array.length-1);
		/*ms.MergeAftersort(array, 0, array.length-1);*/
		/*long start = System.currentTimeMillis();
		qs.quickSortRandom(array, 0, array.length-1);
		long end = System.currentTimeMillis();
		System.out.println("Time : " + (end - start)/1000.0 + "ms");*/
		
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+ " ");
		}
		
	}
	
	
}
