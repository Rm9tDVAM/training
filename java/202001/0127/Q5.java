import java.util.Scanner;
import java.util.Random;
public class Q5{
	public static void main(String[] args){
		System.out.print("配列の要素数を入力してください>");
		int input=new Scanner(System.in).nextInt();
		int[] arr=new int[input];
		System.out.println("配列を生成しました");
		for(int i=0;i<arr.length;i++){
			arr[i]=new Random().nextInt(21)-10;
		}
		printArr(arr);
		while(true){
			System.out.print("1...元の配列を表示,2...配列を昇順ソート,3...配列を降順ソート,4...終了>");
			int select=new Scanner(System.in).nextInt();
			switch(select){
				case 1:
					printArr(arr);
					break;
				case 2:
					sortArr(arr);
					break;
				case 3:
					sortArr(arr,true);
					break;
				case 4:
					System.out.println("アプリケーションを終了します");
					return;
			}
		}
	}
	public static void sortArr(int[] arr,boolean Judge){
		int[] tempArr=new int[arr.length];
		for(int i=0;i<arr.length;i++){
			tempArr[i]=arr[i];
		}
		for(int i=0;i<tempArr.length-1;i++){
			for(int j=i;j<tempArr.length-1;j++){
				if(tempArr[i]<tempArr[j+1]){
					int temp=0;
					temp=tempArr[i];
					tempArr[i]=tempArr[j+1];
					tempArr[j+1]=temp;
				}
			}
		}
		printArr(tempArr);
	}
	public static void sortArr(int[] arr){
		int[] tempArr=new int[arr.length];
		for(int i=0;i<arr.length;i++){
			tempArr[i]=arr[i];
		}
		for(int i=0;i<tempArr.length-1;i++){
			for(int j=i;j<tempArr.length-1;j++){
				if(tempArr[i]>tempArr[j+1]){
					int temp=0;
					temp=tempArr[i];
					tempArr[i]=tempArr[j+1];
					tempArr[j+1]=temp;
				}
			}
		}
		printArr(tempArr);
	}
	public static void printArr(int[] arr){
		System.out.print("{");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
			if(i<arr.length-1){
				System.out.print(",");
			}
		}
		System.out.println("}");
	}
}
