import java.util.Arrays;
import java.util.Random;
public class Q2{
	public static void main(String[] args){
		int[] arr=new int[10];
		for(int i=0;i<arr.length;i++){
			arr[i]=new Random().nextInt(100)+1;
		}
		System.out.println(Arrays.toString(arr));
		sortArr(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void sortArr(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=i;j<arr.length-1;j++){
				if(arr[i]>arr[j+1]){
					int temp=0;
					temp=arr[i];
					arr[i]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
}
