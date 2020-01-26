import java.util.Scanner;
public class Q5_8{
	public static void main(String[] args){
		int[] numBox=new int[10];

		for(int i=0;i<numBox.length;i++){
			System.out.print(i+1+" input num<");
			numBox[i]=new Scanner(System.in).nextInt();
		}

		for(int i=0;i<numBox.length-1;i++){
			for(int j=0,k=1;j<numBox.length-1-i;j++,k++){
				if(numBox[j]>numBox[k]){
					int temp=numBox[j];
					numBox[j]=numBox[k];
					numBox[k]=temp;
				}
			}
		}

		for(int n:numBox){
			System.out.print(n+" ");
		}
	}
}
