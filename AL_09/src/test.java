import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class test {

	public static void main(String[] args) throws IOException {
		FileReader filereader = new FileReader("C://graph.txt");
		BufferedReader bufReader = new BufferedReader(filereader);
		int i = 0;
		String line = "";
		String[] store = null;
		line = bufReader.readLine();
		store = line.split("\n");
		int index = Integer.parseInt(store[0]);
		int[][] arr = new int[index][index];
		while ((line = bufReader.readLine()) != null) {
			store = line.split(" ");
			for (int j = 0; j < store.length; j++) {
				arr[i][j] = Integer.parseInt(store[j]);
			}
			i++;
		}
		bufReader.close();
		DFS dfs = new DFS(arr);
		BFS bfs = new BFS(arr,2);//2번쨰 인자에 시작할 정점 선택함
	}

	

}
