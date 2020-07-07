import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        String str=Integer.toBinaryString(x);
        for(int i=0,temp=0;i<n;i++){
            temp=sc.nextInt();
            System.out.println(str.charAt(str.length()-temp));
        }
        sc.close();
    }
}