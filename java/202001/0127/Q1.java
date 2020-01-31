import java.util.Arrays;
public class Q1{
	public static void main(String[] args){
		int[] arr={1,2,3,4,5},arr2;
		arr2=cloneArr(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
	}
	public static int[] cloneArr(int[] arr){
		int[] temp=new int[arr.length];
		for(int i=0;i<arr.length;i++){
			temp[i]=arr[i];
		}
		return temp;
	}
}
