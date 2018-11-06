
import java.util.Map;
import java.io.*;
import java.util.StringTokenizer;

public class test {
	public static void main(String args[]) {

		
		LinearProbingHashTable Linear = new LinearProbingHashTable(); // �������� ��ü
		QuadraticProbingHashTable Quadratic = new QuadraticProbingHashTable(); // �������� ��ü
		DoubleHashingHashTable Double = new DoubleHashingHashTable(); // �������� ��ü
		int lineCount = 0; // �ؽ�Ʈ ������ �� �� ����
		try {
			BufferedReader read = new BufferedReader(new FileReader("C://data1.txt"));
			String line = read.readLine();
			while (line != null) {
				++lineCount; // �� �� ī��Ʈ ����
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!"); // " ,:;-.?!"�� ������
				while (parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase(); // �ܾ �ϳ��� �о word�� ����
					Linear.put(word, word); // ���������ؽ����̺� ����
					Quadratic.put(word, word); // ���������ؽ����̺� ����
					Double.put(word, word); // ���������ؽ����̺� ����
				}
				line = read.readLine();
			}
			read.close();

		} catch (IOException e) {
			System.out.println();
		}
		try {
			BufferedReader read = new BufferedReader(new FileReader("C://data2.txt"));
			String line = read.readLine();
			while (line != null) {
				++lineCount; // �� �� ī��Ʈ ����
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!"); // " ,:;-.?!"�� ������
				while (parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase(); // �ܾ �ϳ��� �о word�� ����
					Double.remove(word); // ���������ؽ����̺� ����
				}
				line = read.readLine();
			}
			read.close();

		} catch (IOException e) {
			System.out.println();
		}
		try {
			BufferedReader read = new BufferedReader(new FileReader("C://data3.txt"));
			String line = read.readLine();
			while (line != null) {
				++lineCount; // �� �� ī��Ʈ ����
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!"); // " ,:;-.?!"�� ������
				while (parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase(); // �ܾ �ϳ��� �о word�� ����
					Double.get(word); // ���������ؽ����̺� ����
				}
				line = read.readLine();
			}
			read.close();

		} catch (IOException e) {
			System.out.println();
		}

		System.out.println("      Collision Count      ");
		/*System.out.print("LineProb: ");
		Linear.collision();//�������� �浹Ƚ��
		System.out.print("QuadProb: ");
		Quadratic.collision();//�������� �浹Ƚ��
*/		
		Double.collision();//�������� �浹Ƚ��
		Double.wirteFile();
		/*Double.wirteFile();*/
	}
}