import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();sc.nextLine();
        int a=0;
        int b=0;
        String str;
        for(int i=0;i<n;i++){
            str=sc.nextLine();
            String[] sArr=str.split(" ");
            // SET
            if(str.contains("SET")&&Integer.parseInt(sArr[1])==1){
                a=Integer.parseInt(sArr[2]);
            }else if(str.contains("SET")&&Integer.parseInt(sArr[1])==2){
                b=Integer.parseInt(sArr[2]);
            }
            // ADD
            if(str.contains("ADD")){
                b=a+Integer.parseInt(sArr[1]);
            }
            // SUB
            if(str.contains("SUB")){
                b=a-Integer.parseInt(sArr[1]);
            }
        }
        System.out.print(a+" "+b);
        sc.close();
    }
}