import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        double y=sc.nextInt();
        double z=sc.nextInt();
        System.out.print((int)((x*(z/100))-(x*(y/100))));
        sc.close();
    }
}