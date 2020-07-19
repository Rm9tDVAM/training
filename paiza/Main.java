import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int ATK=sc.nextInt();
        int DEF=sc.nextInt();
        int AGI=sc.nextInt();
        int N=sc.nextInt();sc.nextLine();
        for(int i=0,count=0;i<N;i++){
            String[] sArr=sc.nextLine().split(" ");
            if((Integer.parseInt(sArr[1])<=ATK&&ATK<=Integer.parseInt(sArr[2]))&&
                (Integer.parseInt(sArr[3])<=DEF&&DEF<=Integer.parseInt(sArr[4]))&&
                (Integer.parseInt(sArr[5])<=AGI&&AGI<=Integer.parseInt(sArr[6]))){
                System.out.println(sArr[0]);
                count++;
            }
            if(i+1==N&&count==0){
                System.out.println("no evolution");
            }
        }
        sc.close();
    }
}