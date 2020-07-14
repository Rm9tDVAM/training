import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        // 1<=N<=1000, 各レシートの数
        int N=sc.nextInt();sc.nextLine();
        String[] sArr=new String[N];
        for(int i=0;i<sArr.length;i++){
            sArr[i]=sc.nextLine();
        }
        // 1<=d_i<=31, 日付
        // 1<=p_i<=10000, 購入金額
        int point=0;
        for(int i=0;i<sArr.length;i++){
            String[] tArr=sArr[i].split(" ");
            String d_i=tArr[0];
            int p_i=Integer.parseInt(tArr[1]);
            if(d_i.contains("5")){
                point+=(int)Math.floor(p_i*0.05);
            }else if(d_i.contains("3")){
                point+=(int)Math.floor(p_i*0.03);
            }else{
                point+=(int)Math.floor(p_i*0.01);
            }
        }
        System.out.print(point);
        sc.close();
    }
}