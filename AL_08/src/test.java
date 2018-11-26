import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lineCount = 0; // 텍스트 파일의 줄 수 저장
		int count = 0;
		String array[] = new String[4];
		try {
			File file = new File("C://LCS_Data.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufReader.readLine()) != null) { // 한 줄씩 읽어들여
				String number = line;// 정수형으로 캐스팅하고
				array[count] = number;// 배열에 추가
				count++;
			}
			bufReader.close();

		} catch (IOException e) {
			System.out.println(e);
		}
		LCS lcs = new LCS();
		lcs.LongestCommonSubsequence(array[1], array[3]);
		
		

	}
	
	

}
