import java.util.*;
public class ListLesson{
	public static void main(String[] args){
		ArrayList<String> names=new ArrayList<>();
		names.add("たなか");
		names.add("すずき");
		names.add("さいとう");
		System.out.println(names.get(1));

		ArrayList<Integer> points=new ArrayList<>();
		points.add(10);
		points.add(80);
		points.add(75);
		points.add(1,100);
		points.set(2,200);
		int removedNum=points.remove(2);
		System.out.println(points.get(0));
		for(int i=0;i<points.size();i++){
			System.out.println(points.get(i));
		}
		if(points.isEmpty()){
			System.out.println("要素数は0です");
		}else{
			System.out.println("要素数は0ではりません");
		}
		if(points.contains(10)){
			System.out.println("リストに10は含まれています");
		}else{
			System.out.println("リストに10は含まれています");
		}
		for(int i:points){
			System.out.println(i);
		}
	}
}
