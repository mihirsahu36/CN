import java.util.Scanner;
public class Bellmanford {
	public static void main(String[] args) {
		System.out.println("enter number of vertices");
		int num;
		int source;
		Scanner sc=new Scanner(System.in);
		num=sc.nextInt();
		int ad[][]=new int[num][num];
		System.out.println("enter the adjacency matrix");
		for(int i=0;i<num;i++)
		{
			for(int j=0;j<num;j++) {
				ad[i][j]=sc.nextInt();
				}
		}
		System.out.println("enter the source node");
		source=sc.nextInt();
		bellford(ad,num,source);
	} 
	private static void bellford(int[][] ad,int num,int source) {
		int d[]=new int[num];
		for(int i=0;i<num;i++) {
			d[i]=999;
		}
		d[source]=0;
		for(int i=0;i<num-1;i++) {
			for(int u=0;u<num;u++) {
				for(int v=0;v<num;v++) {
					if(d[u] !=999) {
						if(d[v]>d[u]+ad[u][v]) {
							d[v]=d[u]+ad[u][v];
						}
					}
				}
			}
		}
		for(int i=0;i<num;i++) {
			System.out.println("distance of source"+source+"to"+i+"is"+d[i]);
		}
	}
}
