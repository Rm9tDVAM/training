import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        // 0<=X,Y,Z<=3,000
        int X=sc.nextInt(); // 9-17
        var Y=sc.nextInt(); // 17-22
        int Z=sc.nextInt(); // 22-09
        // 1<=N<=100
        int N=sc.nextInt();
        // 0<=S<T<23
        int[] iArr=new int[24];
        for(int i=0;i<iArr.length;i++){
            if(i<=8){
                iArr[i]=Z;
            }else if(i<=16){
                iArr[i]=X;
            }else if(i<=21){
                iArr[i]=Y;
            }else{
                iArr[i]=Z;
            }
        }
        int sum=0;
        for(int i=0;i<N;i++){
            int S=sc.nextInt();
            int T=sc.nextInt();
            for(int j=S;j<T;j++){
                sum+=iArr[j];
            }
        }
        System.out.print(sum);
        sc.close();
    }
}