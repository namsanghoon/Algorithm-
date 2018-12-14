import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class prim {
	int V; 
	int size;
	int[] vertices;// ����
	int[][] weight;// ����ġ �׷���
	int prev[]; // �� ������ ������, �� ������ �ִܰŸ�����
	int distance[]; // ���������� �ش��������� �Ÿ�
	boolean visited[];// �湮 ��ũ Ȯ��
	int start;
	
	public prim() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("C://prim.txt"))); // �������
			String s = br.readLine(); // ��Ʈ�� ������ ��ȯ
			size = Integer.parseInt(s);
			
			V=size;// ��Ʈ������ ��ȯ ��Ų �� size�� ����
			distance = new int[size]; // sizeũ�� ��ŭ ����
			weight = new int[size][size];
			vertices = new int[size];
			for (int i = 0; i < size; i++) { // �ؽ�Ʈ�� �ִ� �������� vertices�� ����
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

	public void add(String v, String w, int x) { // �ؽ�Ʈ���� �޾� ���� ���� 2���� ����ġ ��Ʈ�� ���� 1���� �޾� �׷������ٰ� ����
		int i = index(v), j = index(w);// index�޼ҵ带 ���� �޾ƿ� ���ڸ� ���ڷ� ��ȯ ��,
		weight[i][j] = weight[j][i] = x;// ����ġ �׷����� ����
	}

	public int index(String v) {
		for (int i = 0; i < size; i++)
			if (vertices[i] == Integer.parseInt(v))
				return i;
		return weight.length;
	}
	  
    // A utility function to find the vertex with minimum key 
    // value, from the set of vertices not yet included in MST 
    int minKey(int key[], Boolean mstSet[]) 
    { 
        // Initialize min value 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (mstSet[v] == false && key[v] < min) 
            { 
                min = key[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
    void printMST(int parent[], int n, int graph[][]) 
    { 
        System.out.println("Edge \tWeight"); 
        for (int i = 1; i < V; i++) 
            System.out.println(parent[i]+" - "+ i+"\t"+ 
            		"  "+weight[i][parent[i]]); 
    } 
    void primMST() 
    { 
        // Array to store constructed MST 
        int parent[] = new int[V]; 
  
        // Key values used to pick minimum weight edge in cut 
        int key[] = new int [V]; 
  
        // To represent set of vertices not yet included in MST 
        Boolean mstSet[] = new Boolean[V]; 
  
        // Initialize all keys as INFINITE 
        for (int i = 0; i < V; i++) 
        { 
            key[i] = Integer.MAX_VALUE; 
            mstSet[i] = false; 
        } 
  
        // Always include first 1st vertex in MST. 
        key[0] = 0;     // Make key 0 so that this vertex is 
                        // picked as first vertex 
        parent[0] = -1; // First node is always root of MST 
  
        // The MST will have V vertices 
        for (int count = 0; count < V-1; count++) 
        { 
            // Pick thd minimum key vertex from the set of vertices 
            // not yet included in MST 
            int u = minKey(key, mstSet); 
  
            // Add the picked vertex to the MST Set 
            mstSet[u] = true; 
  
            // Update key value and parent index of the adjacent 
            // vertices of the picked vertex. Consider only those 
            // vertices which are not yet included in MST 
            for (int v = 0; v < V; v++) 
  
                // graph[u][v] is non zero only for adjacent vertices of m 
                // mstSet[v] is false for vertices not yet included in MST 
                // Update the key only if graph[u][v] is smaller than key[v] 
                if (weight[u][v]!=0 && mstSet[v] == false && 
                		weight[u][v] < key[v]) 
                { 
                    parent[v] = u; 
                    key[v] = weight[u][v]; 
                } 
        } 
  
        // print the constructed MST 
        printMST(parent, V, weight); 
    } 
}
