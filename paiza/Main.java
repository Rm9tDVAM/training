import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=9
        int r=0;
        String s=sc.nextLine();
        String[] sArr=new String[n];
        for(int i=0;i<n;i++){
            sArr[i]=String.valueOf(s.charAt(i));
        }
        for(int i=0;i<n;i++){
            if(sArr[i].equals("a")){
                r+=1;
            }
        }
        System.out.print(n-r+" "+r);
        sc.close();
    }
}