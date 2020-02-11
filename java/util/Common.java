package util;
import java.util.*;
public class Common{
//int
//数値を文字列に変換する
	public static String intToString(int num){
		return String.valueOf(num);
	}
//数値の桁数を取得する
	public static int intLength(int num){
		return String.valueOf(num).length();
	}
//数値を桁ごとに配列に収める
//int[] temp=util.Common.intToiArr(8754198);
//[8, 7, 5, 4, 1, 9, 8]
	public static int[] intToiArr(int num){
		int temp=intLength(num);
		int j=1;
		int[] arr=new int[temp];
		for(int i=0;i<arr.length-1;i++){
			j*=10;
		}
		for(int i=0;i<arr.length;i++,j/=10){
			arr[i]=num/j;
			num%=j;
		}
		return arr;
	}

//char

//String

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
}
