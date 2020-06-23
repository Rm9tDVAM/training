import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();sc.nextLine();
        int sum=0;
        String str=sc.nextLine();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==('R')){
                sum++;
            }
        }
        System.out.print(n-sum+" "+sum);
        sc.close();
    }
}