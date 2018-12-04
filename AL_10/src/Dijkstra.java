import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Dijkstra {
	int size; 
	int[] vertices;//정점
	int[][] weight;//가중치 그래프
	int prev[]; //한 정점이 있을때, 그 전까지 최단거리정점
	int distance[]; //시작점에서 해당정점까지 거리 
	boolean visited[];//방문 마크 확인
	int start_index;
	public Dijkstra() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("C://graph_sample_dijkstra.txt"))); //경로지정
			String s = br.readLine(); // 스트링 변수로 반환
			size = Integer.parseInt(s); // 인트형으로 변환 시킨 후 size에 저장
			distance = new int[size]; //size크기 만큼 생성
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

			for (int i = 0; i < size; i++) { //텍스트에 있는 정점들을 vertices에 저장
				vertices[i] = i;
			}
			while ((s = br.readLine()) != null) { // split메소드를 이용해 텍스트안의 줄을 입력받아 가중치값을 add 메소드를 통해 추가
				String str = s;
				String[] result = str.split(" ");
				add(result[0], result[1], Integer.parseInt(result[2]));
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	public void add(String v, String w, int x) { //텍스트에서 받아 들인 문자 2개와 가중치 인트형 변수 1개를 받아 그래프에다가 삽입
		int i = index(v), j = index(w);//index메소드를 통해 받아온 문자를 숫자로 변환 후, 
		weight[i][j] = x;//가중치 그래프에 삽입
	}

	public void dijkstra(String v) {
		start_index = index(v);
		distance = new int[size]; //사이즈 크기만큼  생성
		boolean[] visited = new boolean[size];//방문 했는지 유무
		prev = new int[size];
		
		for (int i = 0; i < size; i++) { //distance 초기화
			distance[i] = Integer.MAX_VALUE;
		}
		distance[index(v)] = 0; //자기자신과의 거리는 0
		
		for (int i = 0; i < size; i++) { //인접한 정점이 있는지 확인 휴, 거리 삽입
			if (visited[i]==false && weight[index(v)][i] > 0) {
				distance[i] = weight[index(v)][i];
				prev[i] = index(v);
			}
			
		}
		visited[index(v)] = true;//방문 마크
		
		for (int x = 0; x < size - 1; x++) {
			// 정점이 n개 있을 때 처음 시작점은 빼야하므로,  반복수는 n-1
			int min = Integer.MAX_VALUE;//최소값 초기값 설정
			int min_index = 0;//최소값을 가지는 인덱스 초기값 설정

			// 최소값 찾기
			for (int i = 0; i < size; i++) {
				if (visited[i] ==false && distance[i] != Integer.MAX_VALUE) { //아직 방문 되지 않았으면서 거리값이 존재하면
					if (distance[i] < min) { //최소값이랑 비교를 해서 만약 작으면
						min = distance[i];//그 값을 최소값이라고 정하고
						min_index = i;//그 인덱스를 min_index에 저장
					}
				}
			}
			visited[min_index] = true; // 위의 방문배열(visited[])의 위의 인덱스 값에 마크합니다.
			for (int i = 0; i < size; i++) { //정보 갱신을 위한 반복문
				if (visited[i]==false && weight[min_index][i] != -1 // 아직 방문 되지않았으면서 
						&& distance[i] > distance[min_index] + weight[min_index][i]) {// 현재 그 정점까지의 거리 (distance[min_index]) + 정점 i까지의 거리가
			                                                                            // 기존의 i정점까지의 거리보다 가깝다면 그 정보를 갱신해준다
					distance[i] = distance[min_index] + weight[min_index][i];
					prev[i] = min_index;//최단거리 배열에 저장
				}
			}
			
		}
	//System.out.println(v); // 시작 정점 표시
	
		 
	}
	public void printpath(String v) {//도착지점 정점을 인자로 받고
		int i = index(v); //index메소드를 통해 인트형으로 변환
		int j;
		j = i; //그 값을 j에 넣고
		if (j != start_index) {//j가 0이 아니면 즉, 시작정점이 아니라면
			j = prev[j];// 도착지점의 전 정점으로 이동
			printpath(Integer.toString(vertices[j]));//다시 재귀
			System.out.print("-> "+v+"("+distance[i]+")"); //정점입력과 거리 출력
			
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
		System.out.println("시작 정점 : " + v);
		for(int i=0; i<size; i++) {
			System.out.print(i+"까지 최단 거리 "+index(v)+" ");
			if(i==index(v)) {
				System.out.print(" 0");
			}
			printpath(Integer.toString(i));
			System.out.println();
		}
	}
}

