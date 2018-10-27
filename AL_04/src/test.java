import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.sun.corba.se.impl.orbutil.graph.Node;

public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int array[] = new int[10];
		int count = 0;

		try {
			File file = new File("C://data1.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufReader.readLine()) != null) { // 한 줄씩 읽어들여
				int number = Integer.parseInt(line);// 정수형으로 캐스팅하고
				array[count] = number;// 배열에 추가
				count++;
			}
			bufReader.close();

		} catch (IOException e) {
			System.out.println(e);
		}
		bst tree = new bst();
		tree.median_insert(array);
		tree.inorder();
		tree.wirteFile();
	}

}
