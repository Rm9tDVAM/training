import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String intStr=str.replaceAll("[^0-9]","");
        System.out.print(intStr);
        sc.close();
    }
}