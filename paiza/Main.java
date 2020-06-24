import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int sum=0;
        for(int i=0;i<2;i++){
            sum+=sc.nextInt();
        }
        if(sum>=16){
            System.out.print("STAND");
        }else{
            System.out.print("HIT");
        }
        sc.close();
    }
}