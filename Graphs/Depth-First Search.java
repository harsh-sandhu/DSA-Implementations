import java.util.ArrayList;
import java.util.Scanner;
public class DFS {

	//Maximum capacity N
	final static int N = (int)1E+5;
	//visited boolean array
	static boolean vis[]=new boolean[N];

	//DFS logic
	private static void dfs(int src,ArrayList<ArrayList<Integer>> adj) {
		vis[src]=true;
		System.out.print(src+" ");
		for(int i:adj.get(src)) {
			if(!vis[i])
				dfs(i,adj);
		}

	}
	public static void dfs(ArrayList<ArrayList<Integer>> adj) {
		for(int i=0;i<adj.size();i++) {
			if(!vis[i]) {
				dfs(i,adj);
			}
		}
		System.out.println();
	}


	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();

		//Adjacency List
		ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}

		//inputing the connection
		for(int i=0;i<m;i++) {
			int p=sc.nextInt();
			int q=sc.nextInt();
			adj.get(p).add(q);
			adj.get(q).add(p);
		}
		//closing the scanner( Nothing to do with DFS logic)
		sc.close();


		dfs(adj);
	}
}
