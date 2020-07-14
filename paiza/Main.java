import java.util.*;
import java.util.stream.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();sc.nextLine();
        String str=sc.nextLine();
        List<String> sList=Arrays.stream(str.split(" "))
            .collect(Collectors.toList());
        // 点数 10 倍カードがある場合、総合点は上記の合計点の 10 倍とする。
        int mag=1;
        if(sList.contains("x10")){
            sList.remove(sList.indexOf("x10"));
            mag=10;
        }
        List<Integer> iList = sList.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        // 点数 0 カードが ある場合、点数カードの中で最大の点を持つカードを 0 点にする。
        if(sList.contains("0")){
            iList.remove(iList.indexOf(Collections.max(iList)));
        }
        // 点数カードの合計点を計算する。
        int sum=0;
        for(int i:iList){
            sum+=i;
        }
        System.out.print(sum*mag);
        sc.close();
    }
}