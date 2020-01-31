import java.util.Arrays;
public class MethodLesson11{
	static void timesArray(int[] arr,int times){
		for(int i=0;i<arr.length;i++){
			arr[i]=arr[i]*times;
		}
	}
	public static void main(String[] args){
		int[] arr1=new int[]{1,2,3};
		timesArray(arr1,2);
		System.out.println(Arrays.toString(arr1));
		timesArray(arr1,3);
		System.out.println(Arrays.toString(arr1));
	}
}
