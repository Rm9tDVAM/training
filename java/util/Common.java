package util;
import java.util.*;
public class Common{
	public static void arrReverse(int[] arr){
		for(int i=0;i<arr.length/2;i++){
			int temp=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
		}
	}
	public static void arrShuffle(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			int index=new Random().nextInt(arr.length-i);
			int temp=arr[index];
			arr[index]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
		}
	}
	public static void arrShuffle(String[] arr){
		for(int i=0;i<arr.length-1;i++){
			int index=new Random().nextInt(arr.length-i);
			String temp=arr[index];
			arr[index]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
		}
}
