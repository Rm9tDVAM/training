import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int min=99;
        int max=0;
        for(int i=0,temp=0;i<5;i++){
            temp=sc.nextInt();
            if(temp<min){
                min=temp;
            }
            if(temp>max){
                max=temp;
            }
        }
        System.out.printf("%d%n%d",max,min);
        sc.close();
    }
}