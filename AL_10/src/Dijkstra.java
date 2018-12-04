import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Dijkstra {
	int size; 
	int[] vertices;//����
	int[][] weight;//����ġ �׷���
	int prev[]; //�� ������ ������, �� ������ �ִܰŸ�����
	int distance[]; //���������� �ش��������� �Ÿ� 
	boolean visited[];//�湮 ��ũ Ȯ��
	int start_index;
	public Dijkstra() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("C://graph_sample_dijkstra.txt"))); //�������
			String s = br.readLine(); // ��Ʈ�� ������ ��ȯ
			size = Integer.parseInt(s); // ��Ʈ������ ��ȯ ��Ų �� size�� ����
			distance = new int[size]; //sizeũ�� ��ŭ ����
			weight = new int[size][size];
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++) {
					if(i==j) {
						weight[i][j] =0;
					}
					else
						weight[i][j] = -1;
				}
			}
			vertices = new int[size];

			for (int i = 0; i < size; i++) { //�ؽ�Ʈ�� �ִ� �������� vertices�� ����
				vertices[i] = i;
			}
			while ((s = br.readLine()) != null) { // split�޼ҵ带 �̿��� �ؽ�Ʈ���� ���� �Է¹޾� ����ġ���� add �޼ҵ带 ���� �߰�
				String str = s;
				String[] result = str.split(" ");
				add(result[0], result[1], Integer.parseInt(result[2]));
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	public void add(String v, String w, int x) { //�ؽ�Ʈ���� �޾� ���� ���� 2���� ����ġ ��Ʈ�� ���� 1���� �޾� �׷������ٰ� ����
		int i = index(v), j = index(w);//index�޼ҵ带 ���� �޾ƿ� ���ڸ� ���ڷ� ��ȯ ��, 
		weight[i][j] = x;//����ġ �׷����� ����
	}

	public void dijkstra(String v) {
		start_index = index(v);
		distance = new int[size]; //������ ũ�⸸ŭ  ����
		boolean[] visited = new boolean[size];//�湮 �ߴ��� ����
		prev = new int[size];
		
		for (int i = 0; i < size; i++) { //distance �ʱ�ȭ
			distance[i] = Integer.MAX_VALUE;
		}
		distance[index(v)] = 0; //�ڱ��ڽŰ��� �Ÿ��� 0
		
		for (int i = 0; i < size; i++) { //������ ������ �ִ��� Ȯ�� ��, �Ÿ� ����
			if (visited[i]==false && weight[index(v)][i] > 0) {
				distance[i] = weight[index(v)][i];
				prev[i] = index(v);
			}
			
		}
		visited[index(v)] = true;//�湮 ��ũ
		
		for (int x = 0; x < size - 1; x++) {
			// ������ n�� ���� �� ó�� �������� �����ϹǷ�,  �ݺ����� n-1
			int min = Integer.MAX_VALUE;//�ּҰ� �ʱⰪ ����
			int min_index = 0;//�ּҰ��� ������ �ε��� �ʱⰪ ����

			// �ּҰ� ã��
			for (int i = 0; i < size; i++) {
				if (visited[i] ==false && distance[i] != Integer.MAX_VALUE) { //���� �湮 ���� �ʾ����鼭 �Ÿ����� �����ϸ�
					if (distance[i] < min) { //�ּҰ��̶� �񱳸� �ؼ� ���� ������
						min = distance[i];//�� ���� �ּҰ��̶�� ���ϰ�
						min_index = i;//�� �ε����� min_index�� ����
					}
				}
			}
			visited[min_index] = true; // ���� �湮�迭(visited[])�� ���� �ε��� ���� ��ũ�մϴ�.
			for (int i = 0; i < size; i++) { //���� ������ ���� �ݺ���
				if (visited[i]==false && weight[min_index][i] != -1 // ���� �湮 �����ʾ����鼭 
						&& distance[i] > distance[min_index] + weight[min_index][i]) {// ���� �� ���������� �Ÿ� (distance[min_index]) + ���� i������ �Ÿ���
			                                                                            // ������ i���������� �Ÿ����� �����ٸ� �� ������ �������ش�
					distance[i] = distance[min_index] + weight[min_index][i];
					prev[i] = min_index;//�ִܰŸ� �迭�� ����
				}
			}
			
		}
	//System.out.println(v); // ���� ���� ǥ��
	
		 
	}
	public void printpath(String v) {//�������� ������ ���ڷ� �ް�
		int i = index(v); //index�޼ҵ带 ���� ��Ʈ������ ��ȯ
		int j;
		j = i; //�� ���� j�� �ְ�
		if (j != start_index) {//j�� 0�� �ƴϸ� ��, ���������� �ƴ϶��
			j = prev[j];// ���������� �� �������� �̵�
			printpath(Integer.toString(vertices[j]));//�ٽ� ���
			System.out.print("-> "+v+"("+distance[i]+")"); //�����Է°� �Ÿ� ���
			
		}
		
	}

	public int index(String v) {
		for (int i = 0; i < size; i++)
			if (vertices[i]==Integer.parseInt(v))
				return i;
		return weight.length;
	}
	public void print(String v) {
		dijkstra(v);
		System.out.println("���� ���� : " + v);
		for(int i=0; i<size; i++) {
			System.out.print(i+"���� �ִ� �Ÿ� "+index(v)+" ");
			if(i==index(v)) {
				System.out.print(" 0");
			}
			printpath(Integer.toString(i));
			System.out.println();
		}
	}
}

