import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int ATK=sc.nextInt();
        int DEF=sc.nextInt();
        int AGI=sc.nextInt();
        int N=sc.nextInt();sc.nextLine();
        for(int i=0,count=0;i<N;i++){
            String[] evoArr=sc.nextLine().split(" ");
            int MINATK=Integer.parseInt(evoArr[1]);
            int MAXATK=Integer.parseInt(evoArr[2]);
            int MINDEF=Integer.parseInt(evoArr[3]);
            int MAXDEF=Integer.parseInt(evoArr[4]);
            int MINAGI=Integer.parseInt(evoArr[5]);
            int MAXAGI=Integer.parseInt(evoArr[6]);
            if((MINATK<=ATK&&ATK<=MAXATK)&&
               (MINDEF<=DEF&&DEF<=MAXDEF)&&
               (MINAGI<=AGI&&AGI<=MAXAGI)){
                   System.out.println(evoArr[0]);
                   count++;
            }
            if(i+1==N&&count==0){
                System.out.println("no evolution");
            }
        }
        sc.close();
    }
}