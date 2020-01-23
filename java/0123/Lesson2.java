public class Lesson2{
	public static void main(String[] args){
		int sum=0;
		for(int i=0;i<args.length;i++){
			int temp=Integer.parseInt(args[i]);
			sum+=temp;
		}
		System.out.print(sum);
	}
}
