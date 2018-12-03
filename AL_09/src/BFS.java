import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public class Graph {

		private String color;
		private int d;// 거리
		private Graph pie = null;
		private int index;

		public Graph(String color) {

		}

		public Graph(String color, int d, Graph pie, int index) {
			this.color = color;
			this.d = d;
			this.pie = null;
			this.index = index;
		}

	}

	private Graph u, v;
	Queue<Graph> queue = new LinkedList<Graph>();

	public BFS(int[][] arr, int start_Vertex) {

		// TODO Auto-generated constructor stub
		Graph[] V = new Graph[arr.length];
		int s = start_Vertex - 1;// s = 시작 정점의 인덱스
		for (int i = 0; i < arr.length; i++) 
			V[i] = new Graph("WHITE", Integer.MAX_VALUE, null, i + 1);

		V[s] = new Graph("GRAY", 0, null, start_Vertex);

		queue.add(V[s]);

		while (!queue.isEmpty()) {
			u = queue.peek();
			for (int i = 0; i < arr.length; i++) {
				if (arr[u.index - 1][i] == 1) {
					v = V[i];
					if (v.color == "WHITE") {
						v.color = "GRAY";
						v.d = u.d + 1;
						v.pie = u;
						queue.add(v);
					}
				}
			}
			u.color = "BLACK";
			u = queue.remove();
		}
		writeFile(V);
	}

	private void writeFile(Graph[] V) {
		// TODO Auto-generated method stub
		String fileName = "Output(BFS).txt";
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
			for (int i = 0; i < V.length; i++) {
				fw.write(i + 1 + " " + V[i].d);
				System.out.println(i + 1 + " " + V[i].d);
				fw.newLine();
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
