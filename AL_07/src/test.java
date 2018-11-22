import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int lineCount = 0; // 텍스트 파일의 줄 수 저장
		String[] splitedStr = null;
		Union_Find uf = new Union_Find();
		try {
			BufferedReader read = new BufferedReader(new FileReader("C://Data_Updated.txt"));
			
			String line = read.readLine();
			while (line != null) {
				++lineCount; // 줄 수 카운트 증가
				splitedStr = null;
				splitedStr = line.split("\t");
				for (int i = 0; i < splitedStr.length; i++) 
					splitedStr[i] = splitedStr[i].trim();
				
				uf.Make_Set(splitedStr[0],splitedStr[1]);
				//uf.Union(splitedStr[0], splitedStr[1]);
				line = read.readLine();
			}
			read.close();

		} catch (IOException e) {
			System.out.println();
		}
			//uf.wirteFile();
			uf.Union_by_key();
			uf.writeFile_output_1();
			uf.Union("1", "2");
			uf.Union("2", "3");
			uf.Union("3", "4");
			uf.Union("4", "5");
			uf.print();
			uf.writeFile_output_2();
	}
	
	

}
