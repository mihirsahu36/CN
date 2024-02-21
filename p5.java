import java.util.Scanner;
public class leaky {
		public static void main(String [] args){
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the bucket size");
			int b_size;
			b_size = sc.nextInt();
			System.out.println("Enter the output rate");
			int op_rate;
			op_rate=sc.nextInt();
			System.out.println("Enter the number of Packets");
			int num;
			num = sc.nextInt();
			int pkts[] = new int [num];
			System.out.println("Enter the packets");
			for(int i=0;i<num;i++){
				pkts[i]=sc.nextInt();
				}
			System.out.println("Rec_Pkt_Size \tBuc_Content \t Acc/Rej \tRem_Buc_content");
	System.out.println("---------------------------------------------------------");
			int Rec_Pkt_Size, Rem_Buc_content =0,Buc_Content=0;
			for(int i =0;i<num;i++){
				Rec_Pkt_Size = pkts[i];
				Buc_Content = Rec_Pkt_Size + Rem_Buc_content;
				if(Buc_Content > b_size){
				Buc_Content = Rem_Buc_content;
				Buc_Content = Rec_Pkt_Size + Rem_Buc_content;
				System.out.println(Rec_Pkt_Size + "\t"+"\t"    + Buc_Content+"     \t    "+"   Rej    \t  " + "\t" + Rem_Buc_content);
				}
				else{
					Buc_Content = Rec_Pkt_Size + Rem_Buc_content;
					Rem_Buc_content = Buc_Content - op_rate;
					if(Rem_Buc_content<0) {
						Rem_Buc_content=0;
					}
					System.out.println(Rec_Pkt_Size +"\t" + "\t" + Buc_Content +"    \t    "+"   Acc   \t"+ "\t" + Rem_Buc_content);
				}
			}
			while(Rem_Buc_content>0) {
				Buc_Content=Rem_Buc_content;
				Rem_Buc_content=Rem_Buc_content-op_rate;
				System.out.println("-- "+"  \t   "+ Buc_Content+"    \t   "+"   --\t   "+Rem_Buc_content);
				}
			}
	}
