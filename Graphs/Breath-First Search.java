import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

	//Maximum Size
	static final int N= (int)1E+5;

	//visted boolean array
	static boolean vis[]=new boolean[N];

	//BFS
	public static void bfs(ArrayList<ArrayList<Integer>> adj) {

		Queue<Integer> q=new LinkedList<>();
		q.add(0);
		while(q.size()>0) {
			int src=q.remove();
			if(!vis[src]) {
				vis[src]=true;
				System.out.print(src+" ");
				for(int i:adj.get(src)) {
					q.add(i);
				}
			}
		}
	}
	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();

		ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<m;i++) {
			int p=sc.nextInt();
			int q=sc.nextInt();

			adj.get(p).add(q);
			adj.get(q).add(p);
		}

		sc.close();

		bfs(adj);
	}

}
