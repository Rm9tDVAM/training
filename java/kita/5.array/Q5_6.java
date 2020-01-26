public class Q5_6{
	public static void main(String[] args){
		int[][] kuku=new int[9][];

		for(int i=0;i<9;i++){
				kuku[i]=new int[9];
			for(int j=0;j<9;j++){
				kuku[i][j]=(i+1)*(j+1);
			}
		}

		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.printf("%3d",kuku[i][j]);
			}
				System.out.println();
		}
	}
}
