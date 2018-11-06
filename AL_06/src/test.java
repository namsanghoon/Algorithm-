
import java.util.Map;
import java.io.*;
import java.util.StringTokenizer;

public class test {
	public static void main(String args[]) {

		
		LinearProbingHashTable Linear = new LinearProbingHashTable(); // 선형조사 객체
		QuadraticProbingHashTable Quadratic = new QuadraticProbingHashTable(); // 제곱조사 객체
		DoubleHashingHashTable Double = new DoubleHashingHashTable(); // 이중조사 객체
		int lineCount = 0; // 텍스트 파일의 줄 수 저장
		try {
			BufferedReader read = new BufferedReader(new FileReader("C://data1.txt"));
			String line = read.readLine();
			while (line != null) {
				++lineCount; // 줄 수 카운트 증가
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!"); // " ,:;-.?!"는 구분자
				while (parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase(); // 단어를 하나씩 읽어서 word에 저장
					Linear.put(word, word); // 선형조사해쉬테이블에 삽입
					Quadratic.put(word, word); // 제곱조사해쉬테이블에 삽입
					Double.put(word, word); // 이중조사해쉬테이블에 삽입
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
				++lineCount; // 줄 수 카운트 증가
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!"); // " ,:;-.?!"는 구분자
				while (parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase(); // 단어를 하나씩 읽어서 word에 저장
					Double.remove(word); // 이중조사해쉬테이블에 삽입
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
				++lineCount; // 줄 수 카운트 증가
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!"); // " ,:;-.?!"는 구분자
				while (parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase(); // 단어를 하나씩 읽어서 word에 저장
					Double.get(word); // 이중조사해쉬테이블에 삽입
				}
				line = read.readLine();
			}
			read.close();

		} catch (IOException e) {
			System.out.println();
		}

		System.out.println("      Collision Count      ");
		/*System.out.print("LineProb: ");
		Linear.collision();//선형조사 충돌횟수
		System.out.print("QuadProb: ");
		Quadratic.collision();//제곱조사 충돌횟수
*/		
		Double.collision();//이중조사 충돌횟수
		Double.wirteFile();
		/*Double.wirteFile();*/
	}
}