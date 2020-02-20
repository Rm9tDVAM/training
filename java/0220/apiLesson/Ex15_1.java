public class Ex15_1{
	public static void main(String[] args){
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<=100;i++){
			sb.append(i);
			sb.append(",");
		}
		System.out.println(sb.toString());
		String[] arr=sb.toString().split(",");
		System.out.println(java.util.Arrays.toString(arr));
	}
}
