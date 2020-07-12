import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        final int N=sc.nextInt();
        String[][] sArr=new String[N][N];
        for(int i=0;i<sArr.length;i++){
            for(int j=0;j<sArr[0].length;j++){
                if(i==j){
                    sArr[i][j]="-";
                }
            }
        }
        int round=((N*N)-N)/2;
        for(int i=0;i<round;i++){
            int f1=sc.nextInt();
            int f2=sc.nextInt();
            sArr[f1-1][f2-1]="W";
            sArr[f2-1][f1-1]="L";
        }
        for(int i=0;i<sArr.length;i++){
            for(int j=0;j<sArr[0].length;j++){
                System.out.print(sArr[i][j]);
                if(!(j+1==sArr[0].length)){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}