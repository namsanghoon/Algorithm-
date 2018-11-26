
public class LCS {
	int up_left = 1;
	int up = 2;
	int left = 3;

	public void LongestCommonSubsequence(String x, String y) {
		int m = x.length();
		int n = y.length();
		int[][] b = new int[m + 1][n + 1];
		int[][] c = new int[m + 1][n + 1];
		

		String[] X = new String[m + 1];
		String[] tempX = x.split("");
		for (int a = 0; a < m; a++) {
			X[a + 1] = tempX[a];
			
		}
		
		String[] Y = new String[n + 1];
		String[] tempY = y.split("");
		for (int a = 0; a < n; a++) {
			Y[a + 1] = tempY[a];
		}

		for (int i = 1; i <= m; i++) {
			c[i][0] = 0;
		}
		for (int j = 1; j <= n; j++) {
			c[0][j] = 0;
		}

		for (int i = 1; i < m+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if (X[i].equals(Y[j])) {
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = up_left;
				} else if (c[i - 1][j] >= c[i][j - 1]) {
					c[i][j] = c[i - 1][j];
					b[i][j] = up;
				} else {
					c[i][j] = c[i][j - 1];
					b[i][j] = left;
				}
			}
		}
		
		print(b, X, m, n);
	}
	
	public void print(int b[][],String X[],int i, int j) {
		if(i==0 || j==0)
			return;
		if(b[i][j]==up_left) {
			print(b,X,i-1,j-1);
			System.out.print(X[i]);
		}
		else if(b[i][j]==up) 
			print(b,X,i-1,j);
		else
			print(b,X,i,j-1);
	}

}
