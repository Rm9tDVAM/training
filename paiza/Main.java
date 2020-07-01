import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        double aa=(double)a/100;
        System.out.print((int)(b*aa+b));
        sc.close();
    }
}