import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = new int[24];
		int count = 0;

		try {
			File file = new File("C://Data1.txt");
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
		RBTree tree = new RBTree();
		tree.add(array);
		tree.searchNode(45);
		
		
		
		
	}

}
