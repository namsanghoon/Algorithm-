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
			while ((line = bufReader.readLine()) != null) { // �� �پ� �о�鿩
				int number = Integer.parseInt(line);// ���������� ĳ�����ϰ�
				array[count] = number;// �迭�� �߰�
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
