import java.util.Arrays;
public class MethodLesson13{
	static int[] timesArray(int[] arr,int times){
		int[] retArr=new int[arr.length];
		for(int i=0;i<retArr.length;i++){
			retArr[i]=arr[i]*times;
		}
		return retArr;
	}
	public static void main(String[] args){
		int[] arr1=new int[]{1,2,3};
		int[] arr2=timesArray(arr1,2);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		int[] arr3=timesArray(arr2,3);
		System.out.println(Arrays.toString(arr3));
	}
}
