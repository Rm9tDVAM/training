import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str="abcde";
        System.out.println(str.substring(0,1));
        System.out.println(str.substring(1,2));
        System.out.println(str.substring(2,3));
        System.out.println(str.substring(str.length()-2,str.length()-1));
        System.out.println(str.substring(str.length()-1));
        sc.close();
    }
}