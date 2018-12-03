
import java.io.*;

public class DFS {
	public class Graph {

		private String color;
		private int depart;
		private Graph pie = null;
		private int Final;
		private int index;

		public Graph() {
		}

		public Graph(String color, Graph pie, int depart, int Final, int index) {
			this.color = color;
			this.pie = null;
			this.depart = depart;
			this.Final = Final;
			this.index = index;
		}
	}

	private Graph u, v;
	int time = 0;
	int[][] Adj;

	public DFS() {
	}

	public DFS(int[][] arr) {
		Graph[] G = new Graph[arr.length];
		Adj = Copy(arr, arr.length);

		for (int i = 0; i < arr.length; i++) {
			int index = i + 1;
			G[i] = new Graph("WHITE", null, 0, 0, index);

		}

		for (int i = 0; i < arr.length; i++) {
			u = G[i];
			if (u.color == "WHITE") {
				DFS_VISIT(G, u);
			}
		}

		writeFile(G);
	}

	public void DFS_VISIT(Graph[] G, Graph u) {
		time = time + 1;
		u.depart = time;
		u.color = "GRAY";
		for (int i = 0; i < Adj.length; i++) {
			if (Adj[u.index - 1][i] == 1) {
				v = G[i];
				if (v.color == "WHITE") {
					v.pie = u;
					DFS_VISIT(G, v);
				}
			}
		}
		u.color = "BLACK";
		time++;
		u.Final = time;
	}
	//배열 카피 메소드
	public static int[][] Copy(int[][] original, int n) {
		if (original == null) {
			return null;
		}

		int[][] result = new int[n][n];
		for (int i = 0; i < original.length; i++) {
			System.arraycopy(original[i], 0, result[i], 0, original[i].length);
		}
		return result;
	}

	public void writeFile(Graph[] V) {
		String fileName = "Output(DFS).txt";
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
			for (int i = 0; i < V.length; i++) {
				fw.write(i + 1 + " " + V[i].depart + " " + V[i].Final);
				System.out.println(i + 1 + " " + V[i].depart + " " + V[i].Final);
				fw.newLine();
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
